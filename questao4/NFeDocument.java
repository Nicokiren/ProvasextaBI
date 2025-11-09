package questao4;

public class NFeDocument {
    private String numero;
    private String xmlContent;
    private double valorTotal;

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