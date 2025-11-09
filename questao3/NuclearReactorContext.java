package questao3;


public class NuclearReactorContext {
    private ReactorState currentState;
    private double temperatura;
    private double pressao;
    private double radiacao;

    public NuclearReactorContext() {
       
        this.currentState = new DesligadaState();
    }

    public void setState(ReactorState newState) {
        System.out.println("--- TRANSICÃO DE ESTADO: " + currentState.getClass().getSimpleName() + " -> " + newState.getClass().getSimpleName() + " ---");
        this.currentState = newState;
    }

    public ReactorState getState() { 
            return currentState;
    }

   

    public void monitor() {
        currentState.verificarAlteracaoEstado(this);
    }

   
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
    public double getPressao() { return pressao; }
    public void setPressao(double pressao) { this.pressao = pressao; }
    public double getRadiacao() { return radiacao; }
    public void setRadiacao(double radiacao) { this.radiacao = radiacao; }

    @Override
    public String toString() {
        return "Reator [Temp=" + temperatura + "C, Pressao=" + pressao + "bar]";
    }
}