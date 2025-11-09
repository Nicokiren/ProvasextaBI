package questao3;

public class AlertaVermelhoState implements ReactorState {
    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
        // Regra: ALERTA_VERMELHO → EMERGENCIA se resfriamento falhar (simulado por pressão > 200)
        if (context.getPressao() > 200) {
             System.out.println("[VERMELHO] FALHA NO RESFRIAMENTO CONFIRMADA!");
             context.setState(new EmergenciaState());
        }
        // Pode voltar para Amarelo se a situação melhorar um pouco, mas não direto para Normal
        else if (context.getTemperatura() <= 400) {
             System.out.println("[VERMELHO] Situação melhorando ligeiramente.");
             context.setState(new AlertaAmareloState());
        }
    }
}