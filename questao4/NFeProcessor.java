package questao4;

import java.util.Collections;
import java.util.List;

/*
    Cliente que monta e executa a cadeia.
*/

public class NFeProcessor {
    private NFeValidator chain;

    public NFeProcessor() {
        buildChain();
    }

    private void buildChain() {
        // Construção da cadeia conforme requisitos:
        // 1 (XML) -> 2 (Cert) -> 3 (Tax - só se 2 ok) -> 4 (DB) -> 5 (Sefaz - só se anteriores ok)
        this.chain = new XMLSchemaValidator();
        this.chain.setNext(new DigitalCertificateValidator())
                  .setNext(new TaxRulesValidator())
                  .setNext(new DatabaseValidator())
                  .setNext(new SefazValidator());
    }

    public void process(NFeDocument nfe) {
        System.out.println("\n>>> Iniciando processamento da " + nfe);
        ValidationContext context = new ValidationContext();

        try {
            chain.validate(nfe, context);
        } catch (Exception e) {
            context.addError("Erro inesperado: " + e.getMessage());
        }

        if (context.hasErrors()) {
            System.out.println("(!) FALHA na validação. Iniciando ROLLBACK...");
            executeRollback(nfe, context);
        } else {
            System.out.println(":) NF-e " + nfe.getNumero() + " processada com SUCESSO!");
        }
    }

    private void executeRollback(NFeDocument nfe, ValidationContext context) {
        List<NFeValidator> executed = context.getExecutedValidators();
        // Executa rollback na ordem inversa
        Collections.reverse(executed);
        for (NFeValidator validator : executed) {
            validator.rollback(nfe);
        }
    }
}