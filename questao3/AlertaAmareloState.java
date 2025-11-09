package questao3;

public class AlertaAmareloState implements ReactorState {
    private int segundosEmAlerta = 0; // Simulação de tempo

    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
        // Simulação de incremento de tempo a cada chamada
        segundosEmAlerta += 5; 

        // Regra: ALERTA_AMARELO → ALERTA_VERMELHO se temp > 400°C por > 30s
        if (context.getTemperatura() > 400) {
            if (segundosEmAlerta > 30) {
                System.out.println("[AMARELO] CRÍTICO: Temperatura > 400C por muito tempo!");
                context.setState(new AlertaVermelhoState());
            } else {
                 System.out.println("[AMARELO] Temperatura crítica! Tempo decorrido: " + segundosEmAlerta + "s");
            }
        } 
        // Bidirecional: Se normalizou, volta para Operação Normal
        else if (context.getTemperatura() <= 300) {
            System.out.println("[AMARELO] Temperatura normalizada. Voltando ao normal.");
            context.setState(new OperacaoNormalState());
        }
    }
}