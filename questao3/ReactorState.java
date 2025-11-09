package questao3;

/*
    Interface State: Define o contrato para todos os estados da usina.
*/

public interface ReactorState {
    void verificarAlteracaoEstado(NuclearReactorContext context);
}