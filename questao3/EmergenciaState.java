package questao3;

public class EmergenciaState implements ReactorState {
    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
        System.out.println("[EMERGÊNCIA] EVACUAR A USINA! SCRAM AUTOMÁTICO INICIADO.");
        // De emergência só se vai para Desligado após controle total, ou permanece aqui.
        if (context.getTemperatura() < 100 && context.getPressao() < 50) {
            System.out.println("[EMERGÊNCIA] Situação controlada. Desligando reator.");
            context.setState(new DesligadaState());
        }
    }
}