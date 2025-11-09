package questao1;



public class RiskProcessor {
    private RiskCalculationStrategy currentStrategy;

    public RiskProcessor(RiskCalculationStrategy initialStrategy) {
        this.currentStrategy = initialStrategy;
    }

    
    
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