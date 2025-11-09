package questao2;

import java.util.HashMap;
import java.util.Map;

/*
    Adapter: Faz a ponte entre a interface moderna e o sistema legado.
    Implementa a interface moderna e compõe o sistema legado.
*/

public class LegacyBankingAdapter implements ProcessadorTransacoes {
    private final SistemaBancarioLegado sistemaLegado;

    public LegacyBankingAdapter(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public TransacaoResponse autorizar(String cartao, double valor, String moeda) {
        // 1. Conversão de Entrada (Moderno -> Legado)
        // DECISÃO DE DESIGN: Encapsular a construção do HashMap complexo aqui
        HashMap<String, Object> paramsLegado = new HashMap<>();
        paramsLegado.put("nr_cartao_x", cartao);
        paramsLegado.put("vlr_tx", valor);

        // Requisito: Codificação específica de moedas (USD=1, EUR=2, BRL=3)
        paramsLegado.put("cod_moeda", converterMoedaParaLegado(moeda));

        // Requisito: Campo obrigatório do legado que não existe no moderno
        paramsLegado.put("COD_SISTEMA_ORIGEM", "APP_MODERNO_V2");

        // 2. Chamada ao Legado
        Map<String, Object> respostaLegado = sistemaLegado.processarTransacao(paramsLegado);

        // 3. Conversão de Saída (Bidirecional: Legado -> Moderno)
        return converterRespostaLegado(respostaLegado);
    }

    private int converterMoedaParaLegado(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD": return 1;
            case "EUR": return 2;
            case "BRL": return 3;
            default: throw new IllegalArgumentException("Moeda não suportada pelo legado: " + moeda);
        }
    }

    private TransacaoResponse converterRespostaLegado(Map<String, Object> resp) {
        // Traduz os códigos obscuros do legado (0 = sucesso) para booleanos modernos
        int codRetorno = (int) resp.get("cod_retorno");
        boolean aprovado = (codRetorno == 0);

        String msg = (String) resp.get("msg_retorno");
        String auth = (String) resp.get("auth_hash"); // Pode ser null se falhou

        return new TransacaoResponse(aprovado, msg, auth);
    }
}