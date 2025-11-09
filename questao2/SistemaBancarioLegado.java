package questao2;

import java.util.HashMap;
import java.util.Map;

/*
    Adaptee: O sistema legado complexo e incompatível.
    Simula um sistema antigo que usa tipos genéricos e códigos obscuros.
*/

public class SistemaBancarioLegado {

    // Método legado que recebe tudo via HashMap e retorna outro HashMap
    public Map<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("[LEGADO] Processando transação no mainframe...");
        System.out.println("[LEGADO] Parâmetros recebidos: " + parametros);

        // Simulação de validação de campo obrigatório legado
        if (!parametros.containsKey("COD_SISTEMA_ORIGEM")) {
             throw new RuntimeException("[LEGADO] ERRO: Campo obrigatório 'COD_SISTEMA_ORIGEM' não informado.");
        }

        // Simulação de resposta do legado
        Map<String, Object> respostaLegado = new HashMap<>();
        double valor = (double) parametros.get("vlr_tx");

        if (valor < 10000) {
            respostaLegado.put("cod_retorno", 0); // 0 = Sucesso no legado
            respostaLegado.put("msg_retorno", "APROVADO_LEGADO");
            respostaLegado.put("auth_hash", "AUTH_" + System.currentTimeMillis());
        } else {
            respostaLegado.put("cod_retorno", 99); // 99 = Erro genérico
            respostaLegado.put("msg_retorno", "LIMITE_EXCEDIDO_LEGADO");
        }

        return respostaLegado;
    }
}