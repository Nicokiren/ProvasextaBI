package questao1;

public class Main {
    public static void main(String[] args) {
      
        FinancialData dados = new FinancialData(1_000_000.00, 0.05, "Agressivo");
        System.out.println("Iniciando sistema para: " + dados);
        System.out.println("===============================================");

        RiskProcessor processador = new RiskProcessor(new ValueAtRiskStrategy());
        processador.executeAnalysis(dados);

        processador.setStrategy(new ExpectedShortfallStrategy());
        processador.executeAnalysis(dados);

        processador.setStrategy(new StressTestingStrategy());
        processador.executeAnalysis(dados);
    }
}