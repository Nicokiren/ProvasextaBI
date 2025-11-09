package questao1;

/*
    Interface Strategy.
    DECISÃO DE DESIGN: O uso de uma interface garante o desacoplamento,
    permitindo que o processador não conheça os detalhes concretos de cada algoritmo.
*/

public interface RiskCalculationStrategy {
    void calculateRisk(FinancialData data);
}