package questao4;

// 1. Validador de Schema XML
class XMLSchemaValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[1] Validando Schema XML...");
        // Simulação: sempre passa
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { /* Nada a desfazer */ }
}

// 2. Validador de Certificado Digital
class DigitalCertificateValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[2] Validando Certificado Digital...");
        // Simulação: falha se o número da NF terminar em '9'
        if (nfe.getNumero().endsWith("9")) {
            context.addError("Certificado expirado");
            // Regra: se certificado falha, não faz sentido continuar para regras fiscais
            context.setFatalError(true); 
            return false;
        }
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}

// 3. Validador de Regras Fiscais
class TaxRulesValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[3] Validando Regras Fiscais...");
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}

// 4. Validador de Banco de Dados (com Rollback)
class DatabaseValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[4] Inserindo pré-registro no Banco de Dados...");
        nfe.setPersistedInDB(true); // Simula persistência
        System.out.println(" -> NF " + nfe.getNumero() + " persistida (Status: Aguardando SEFAZ)");
        return true;
    }

    @Override
    public void rollback(NFeDocument nfe) {
        if (nfe.isPersistedInDB()) {
            System.out.println("[ROLLBACK DB] Removendo registro da NF " + nfe.getNumero() + " do banco!");
            nfe.setPersistedInDB(false);
        }
    }
}

// 5. Validador SEFAZ (Consulta externa que pode falhar)
class SefazValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[5] Consultando serviço da SEFAZ...");
        // Simulação: falha para demonstrar o rollback do DB
        if (nfe.getNumero().endsWith("0")) { // Exemplo: final 0 simula SEFAZ fora do ar
             context.addError("SEFAZ Indisponível (Timeout)");
             return false;
        }
        System.out.println(" -> Autorização SEFAZ recebida com sucesso.");
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}