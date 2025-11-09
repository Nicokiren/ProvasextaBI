package questao3;

public class DesligadaState implements ReactorState {
    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
        
        if (context.getTemperatura() > 0 && context.getTemperatura() < 100) {
             System.out.println("[DESLIGADA] Iniciando reator...");
             context.setState(new OperacaoNormalState());
        }
    }
}