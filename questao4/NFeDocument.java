package questao4;

/*
    Representa o documento fiscal a ser validado.
*/

public class NFeDocument {
    private String numero;
    private String xmlContent;
    private double valorTotal;
    // Flag para indicar se foi inserido no BD (para demonstrar rollback)
    private boolean persistedInDB = false;

    public NFeDocument(String numero, double valorTotal) {
        this.numero = numero;
        this.valorTotal = valorTotal;
        this.xmlContent = "<nfe><num>" + numero + "</num><val>" + valorTotal + "</val></nfe>";
    }

    public String getNumero() { return numero; }
    public boolean isPersistedInDB() { return persistedInDB; }
    public void setPersistedInDB(boolean persisted) { this.persistedInDB = persisted; }

    @Override
    public String toString() {
        return "NFe[" + numero + "]";
    }
}