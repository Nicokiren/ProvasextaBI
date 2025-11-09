package questao4;

import java.util.ArrayList;
import java.util.List;

/*
    Mantém o estado da validação atual, incluindo erros e controle de circuit breaker.
*/

public class ValidationContext {
    private int failureCount = 0;
    private List<String> errors = new ArrayList<>();
    // Pilha para rollback (Command pattern)
    private List<NFeValidator> executedValidators = new ArrayList<>();
    private boolean fatalError = false;

    public void addError(String error) {
        this.errors.add(error);
        this.failureCount++;
        System.out.println("   [CTX] Erro registrado. Total de falhas: " + failureCount);
    }

    public boolean shouldStopChain() {
        // Circuit breaker: interrompe após 3 falhas
        if (failureCount >= 3) {
            System.out.println("   [CTX] CIRCUIT BREAKER ATIVADO! Muitas falhas.");
            return true;
        }
        return fatalError;
    }

    public void setFatalError(boolean fatal) { this.fatalError = fatal; }
    public boolean hasErrors() { return !errors.isEmpty(); }
    public List<String> getErrors() { return errors; }

    public void registerExecuted(NFeValidator validator) {
        executedValidators.add(validator);
    }

    public List<NFeValidator> getExecutedValidators() {
        return executedValidators;
    }
}