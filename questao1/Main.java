package questao1;

public class Main {
    public static void main(String[] args) {
        // 1. Preparação dos dados (Contexto compartilhado)
        FinancialData dados = new FinancialData(1_000_000.00, 0.05, "Agressivo");
        System.out.println("Iniciando sistema para: " + dados);
        System.out.println("===============================================");

        // 2. Instanciação do processador com estratégia inicial
        RiskProcessor processador = new RiskProcessor(new ValueAtRiskStrategy());
        processador.executeAnalysis(dados);

        // 3. Troca dinâmica para Expected Shortfall
        processador.setStrategy(new ExpectedShortfallStrategy());
        processador.executeAnalysis(dados);

        // 4. Troca dinâmica para Stress Testing
        processador.setStrategy(new StressTestingStrategy());
        processador.executeAnalysis(dados);
    }
}