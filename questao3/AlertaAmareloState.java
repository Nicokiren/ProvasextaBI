package questao3;

public class AlertaAmareloState implements ReactorState {
    private int segundosEmAlerta = 0; 

    @Override
    public void verificarAlteracaoEstado(NuclearReactorContext context) {
       
        segundosEmAlerta += 5; 

        
        if (context.getTemperatura() > 400) {
            if (segundosEmAlerta > 30) {
                System.out.println("[AMARELO] CRÍTICO: Temperatura > 400C por muito tempo!");
                context.setState(new AlertaVermelhoState());
            } else {
                 System.out.println("[AMARELO] Temperatura crítica! Tempo decorrido: " + segundosEmAlerta + "s");
            }
        } 
      
        else if (context.getTemperatura() <= 300) {
            System.out.println("[AMARELO] Temperatura normalizada. Voltando ao normal.");
            context.setState(new OperacaoNormalState());
        }
    }
}