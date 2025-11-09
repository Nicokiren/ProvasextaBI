package questao4;

import java.util.Collections;
import java.util.List;


public class NFeProcessor {
    private NFeValidator chain;

    public NFeProcessor() {
        buildChain();
    }

    private void buildChain() {
      
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
       
        Collections.reverse(executed);
        for (NFeValidator validator : executed) {
            validator.rollback(nfe);
        }
    }
}