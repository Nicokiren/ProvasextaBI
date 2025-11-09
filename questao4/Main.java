package questao4;

public class Main {
    public static void main(String[] args) {
        NFeProcessor processor = new NFeProcessor();

        // CASO 1: Sucesso total
        processor.process(new NFeDocument("NF-1234", 1500.00));

        // CASO 2: Falha na SEFAZ (deve acionar rollback do DB)
        // Final '0' aciona erro simulado na SEFAZ
        processor.process(new NFeDocument("NF-5000", 5000.00));

        // CASO 3: Falha logo no Certificado (não deve nem tentar regras fiscais ou DB)
        // Final '9' aciona erro de certificado
        processor.process(new NFeDocument("NF-9999", 100.00));
    }
}