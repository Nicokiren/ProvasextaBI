package questao4;

/*
    Interface base para os validadores (Handler da Chain + Command para rollback).
*/

public abstract class NFeValidator {
    protected NFeValidator next;

    public NFeValidator setNext(NFeValidator next) {
        this.next = next;
        return next; // Permite encadeamento fluente
    }

    public void validate(NFeDocument nfe, ValidationContext context) {
        if (context.shouldStopChain()) {
            return;
        }

        if (doValidate(nfe, context)) {
            // Se passou, registra para possível rollback futuro
            context.registerExecuted(this);
            // Continua a cadeia
            if (next != null) {
                next.validate(nfe, context);
            }
        } else {
            // Se falhou, decide se continua ou não baseado na gravidade
            // Por padrão, a implementação concreta decide se chama o next ou não.
            // Aqui, vamos assumir que se falhou, não chama o próximo se for crítico.
        }
    }

    // Método template para a validação específica
    protected abstract boolean doValidate(NFeDocument nfe, ValidationContext context);

    // Método para rollback (Command pattern)
    public abstract void rollback(NFeDocument nfe);
}