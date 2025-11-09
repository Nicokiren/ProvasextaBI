package questao1;

/*
    Representa o contexto complexo de dados financeiros.
    DECISÃO DE DESIGN: Separar os dados da lógica de cálculo permite que
    o mesmo conjunto de dados seja passado para diferentes estratégias
    sem acoplamento.
*/

public class FinancialData {
    private double totalAssets;
    private double marketVolatility;
    private String portfolioType;

    public FinancialData(double totalAssets, double marketVolatility, String portfolioType) {
        this.totalAssets = totalAssets;
        this.marketVolatility = marketVolatility;
        this.portfolioType = portfolioType;
    }

    public double getTotalAssets() { return totalAssets; }
    public double getMarketVolatility() { return marketVolatility; }
    public String getPortfolioType() { return portfolioType; }

    @Override
    public String toString() {
        return "FinancialData [Assets=" + totalAssets + ", Volatility=" + marketVolatility + ", Type=" + portfolioType + "]";
    }
}