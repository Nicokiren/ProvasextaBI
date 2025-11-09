package questao2;

import java.util.HashMap;
import java.util.Map;



public class LegacyBankingAdapter implements ProcessadorTransacoes {
    private final SistemaBancarioLegado sistemaLegado;

    public LegacyBankingAdapter(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public TransacaoResponse autorizar(String cartao, double valor, String moeda) {
       
        HashMap<String, Object> paramsLegado = new HashMap<>();
        paramsLegado.put("nr_cartao_x", cartao);
        paramsLegado.put("vlr_tx", valor);

       
        paramsLegado.put("cod_moeda", converterMoedaParaLegado(moeda));

       
        paramsLegado.put("COD_SISTEMA_ORIGEM", "APP_MODERNO_V2");

      
        Map<String, Object> respostaLegado = sistemaLegado.processarTransacao(paramsLegado);

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
       
        int codRetorno = (int) resp.get("cod_retorno");
        boolean aprovado = (codRetorno == 0);

        String msg = (String) resp.get("msg_retorno");
        String auth = (String) resp.get("auth_hash"); 

        return new TransacaoResponse(aprovado, msg, auth);
    }
}