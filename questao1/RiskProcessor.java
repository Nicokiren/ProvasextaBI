package questao1;

/*
    Contexto do Strategy.
    Gerencia a estratégia atual e delega a execução.
*/

public class RiskProcessor {
    private RiskCalculationStrategy currentStrategy;

    // Injeção de dependência via construtor para estratégia inicial
    public RiskProcessor(RiskCalculationStrategy initialStrategy) {
        this.currentStrategy = initialStrategy;
    }

    /*
        Permite a troca dinâmica do algoritmo em tempo de execução.
        DECISÃO DE DESIGN: Essencial para cumprir o requisito de intercambiabilidade dinâmica.
    */
    
    public void setStrategy(RiskCalculationStrategy strategy) {
        System.out.println("\n--- Alterando Estratégia de Risco ---");
        this.currentStrategy = strategy;
    }

    public void executeAnalysis(FinancialData data) {
        if (currentStrategy == null) {
            throw new IllegalStateException("Nenhuma estratégia definida.");
        }
        currentStrategy.calculateRisk(data);
    }
}