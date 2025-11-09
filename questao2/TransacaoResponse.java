package questao2;


public class TransacaoResponse {
    private boolean aprovado;
    private String mensagem;
    private String codigoAutorizacao;

    public TransacaoResponse(boolean aprovado, String mensagem, String codigoAutorizacao) {
        this.aprovado = aprovado;
        this.mensagem = mensagem;
        this.codigoAutorizacao = codigoAutorizacao;
    }

    @Override
    public String toString() {
        return "Resposta Moderna [Aprovado=" + aprovado + ", Msg=" + mensagem + ", Cod=" + codigoAutorizacao + "]";
    }
}