package questao4;



public abstract class NFeValidator {
    protected NFeValidator next;

    public NFeValidator setNext(NFeValidator next) {
        this.next = next;
        return next;
    }

    public void validate(NFeDocument nfe, ValidationContext context) {
        if (context.shouldStopChain()) {
            return;
        }

        if (doValidate(nfe, context)) {
           
            context.registerExecuted(this);
            
            if (next != null) {
                next.validate(nfe, context);
            }
        } else {
           
        }
    }

   
    protected abstract boolean doValidate(NFeDocument nfe, ValidationContext context);

    
    public abstract void rollback(NFeDocument nfe);
}