package questao1;



public class StressTestingStrategy implements RiskCalculationStrategy {
    @Override
    public void calculateRisk(FinancialData data) {
        System.out.println("[STRESS] Executando Teste de Stress no portfólio " + data.getPortfolioType() + "...");
       
        double stressLoss = data.getTotalAssets() * 0.30;
        System.out.println(" -> Cenário: Queda de mercado de 30%");
        System.out.println(" -> RESULTADO Perda Estimada: R$ " + String.format("%.2f", stressLoss));
    }
}