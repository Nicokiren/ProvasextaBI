package questao2;

/*
    Target Interface: A interface moderna que o nosso sistema espera usar.
*/

public interface ProcessadorTransacoes {
    // Retorna um objeto tipado moderno, não um HashMap obscuro
    TransacaoResponse autorizar(String cartao, double valor, String moeda);
}