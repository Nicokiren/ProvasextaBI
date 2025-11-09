package questao1;

/*
    Estratégia Concreta: Expected Shortfall.
*/

public class ExpectedShortfallStrategy implements RiskCalculationStrategy {
    @Override
    public void calculateRisk(FinancialData data) {
        System.out.println("[ES] Calculando Expected Shortfall (Risco de Cauda)...");
        // Simulação dummy: considera um cenário pior que o VaR (ex: fator 2.0)
        double result = data.getTotalAssets() * data.getMarketVolatility() * 2.0;
        System.out.println(" -> RESULTADO Expected Shortfall: R$ " + String.format("%.2f", result));
    }
}