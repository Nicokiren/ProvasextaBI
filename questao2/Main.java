package questao2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Integrador de Pagamentos ===\n");

        // Setup: O sistema legado já existe
        SistemaBancarioLegado legado = new SistemaBancarioLegado();

        // O cliente usa apenas a interface moderna, desconhecendo o legado
        // Injeção de dependência: passamos o legado para o adapter
        ProcessadorTransacoes processador = new LegacyBankingAdapter(legado);

        // Teste 1: Transação normal em BRL
        System.out.println(">>> Teste 1: Tentando autorizar R$ 150.00");
        TransacaoResponse resp1 = processador.autorizar("1234-5678-9000-0000", 150.00, "BRL");
        System.out.println("Resultado 1: " + resp1 + "\n");

        // Teste 2: Transação alta (para forçar erro no legado) em USD
        System.out.println(">>> Teste 2: Tentando autorizar $ 50000.00 USD");
        TransacaoResponse resp2 = processador.autorizar("9999-8888-7777-6666", 50000.00, "USD");
        System.out.println("Resultado 2: " + resp2);
    }
}