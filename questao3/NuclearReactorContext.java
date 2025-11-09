package questao3;

/*
    Contexto: Mantém a referência para o estado atual da usina.
*/

public class NuclearReactorContext {
    private ReactorState currentState;
    private double temperatura;
    private double pressao;
    private double radiacao;

    public NuclearReactorContext() {
        // Estado inicial
        this.currentState = new DesligadaState();
    }

    public void setState(ReactorState newState) {
        System.out.println("--- TRANSICÃO DE ESTADO: " + currentState.getClass().getSimpleName() + " -> " + newState.getClass().getSimpleName() + " ---");
        this.currentState = newState;
    }

    public ReactorState getState() { // Adicionado getter para validações externas se necessário
        return currentState;
    }

    /*
        Método chamado periodicamente para verificar se o estado deve mudar
        com base nos sensores atuais.
    */

    public void monitor() {
        currentState.verificarAlteracaoEstado(this);
    }

    // Getters e Setters para os sensores
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