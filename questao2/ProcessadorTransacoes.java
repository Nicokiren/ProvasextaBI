package questao2;


public interface ProcessadorTransacoes {
   
    TransacaoResponse autorizar(String cartao, double valor, String moeda);
}