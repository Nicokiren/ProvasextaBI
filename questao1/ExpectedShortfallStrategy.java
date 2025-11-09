package questao1;


public class ExpectedShortfallStrategy implements RiskCalculationStrategy {
    @Override
    public void calculateRisk(FinancialData data) {
        System.out.println("[ES] Calculando Expected Shortfall (Risco de Cauda)...");
    
        double result = data.getTotalAssets() * data.getMarketVolatility() * 2.0;
        System.out.println(" -> RESULTADO Expected Shortfall: R$ " + String.format("%.2f", result));
    }
}