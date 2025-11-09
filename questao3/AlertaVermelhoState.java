package questao3;

public class AlertaVermelhoState implements ReactorState {
    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
        
        if (context.getPressao() > 200) {
             System.out.println("[VERMELHO] FALHA NO RESFRIAMENTO CONFIRMADA!");
             context.setState(new EmergenciaState());
        }
        
        else if (context.getTemperatura() <= 400) {
             System.out.println("[VERMELHO] Situação melhorando ligeiramente.");
             context.setState(new AlertaAmareloState());
        }
    }
}