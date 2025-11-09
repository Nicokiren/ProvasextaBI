package questao1;

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