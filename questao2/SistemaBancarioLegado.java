package questao2;

import java.util.HashMap;
import java.util.Map;


public class SistemaBancarioLegado {

    public Map<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("[LEGADO] Processando transação no mainframe...");
        System.out.println("[LEGADO] Parâmetros recebidos: " + parametros);

       
        if (!parametros.containsKey("COD_SISTEMA_ORIGEM")) {
             throw new RuntimeException("[LEGADO] ERRO: Campo obrigatório 'COD_SISTEMA_ORIGEM' não informado.");
        }


        Map<String, Object> respostaLegado = new HashMap<>();
        double valor = (double) parametros.get("vlr_tx");

        if (valor < 10000) {
            respostaLegado.put("cod_retorno", 0); 
            respostaLegado.put("msg_retorno", "APROVADO_LEGADO");
            respostaLegado.put("auth_hash", "AUTH_" + System.currentTimeMillis());
        } else {
            respostaLegado.put("cod_retorno", 99); 
            respostaLegado.put("msg_retorno", "LIMITE_EXCEDIDO_LEGADO");
        }

        return respostaLegado;
    }
}