package questao1;

public class ValueAtRiskStrategy implements RiskCalculationStrategy {
    @Override
    public void calculateRisk(FinancialData data) {
        System.out.println("[VaR] Calculando Value at Risk...");
      
        double result = data.getTotalAssets() * data.getMarketVolatility() * 1.65;
        System.out.println(" -> RESULTADO VaR (95% confiança): R$ " + String.format("%.2f", result));
    }
}