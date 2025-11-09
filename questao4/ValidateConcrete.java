package questao4;

class XMLSchemaValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[1] Validando Schema XML...");
        
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) {  }
}

class DigitalCertificateValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[2] Validando Certificado Digital...");
       
        if (nfe.getNumero().endsWith("9")) {
            context.addError("Certificado expirado");
            
            context.setFatalError(true); 
            return false;
        }
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}


class TaxRulesValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[3] Validando Regras Fiscais...");
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}


class DatabaseValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[4] Inserindo pré-registro no Banco de Dados...");
        nfe.setPersistedInDB(true); 
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


class SefazValidator extends NFeValidator {
    @Override
    protected boolean doValidate(NFeDocument nfe, ValidationContext context) {
        System.out.println("[5] Consultando serviço da SEFAZ...");
        
        if (nfe.getNumero().endsWith("0")) { 
             context.addError("SEFAZ Indisponível (Timeout)");
             return false;
        }
        System.out.println(" -> Autorização SEFAZ recebida com sucesso.");
        return true;
    }
    @Override
    public void rollback(NFeDocument nfe) { }
}