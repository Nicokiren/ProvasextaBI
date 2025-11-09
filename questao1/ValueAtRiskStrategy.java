package questao1;

/*
    Estratégia Concreta: Value at Risk (VaR).
*/

public class ValueAtRiskStrategy implements RiskCalculationStrategy {
    @Override
    public void calculateRisk(FinancialData data) {
        System.out.println("[VaR] Calculando Value at Risk...");
        // Simulação de cálculo: Ativos * Volatilidade * Fator de Confiança (ex: 1.65 para 95%)
        double result = data.getTotalAssets() * data.getMarketVolatility() * 1.65;
        System.out.println(" -> RESULTADO VaR (95% confiança): R$ " + String.format("%.2f", result));
    }
}