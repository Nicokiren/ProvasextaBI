package questao3;

public class OperacaoNormalState implements ReactorState {
    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
       
        if (context.getTemperatura() > 300) {
            System.out.println("[NORMAL] AVISO: Temperatura elevada detectada!");
            context.setState(new AlertaAmareloState());
        }
    }
}