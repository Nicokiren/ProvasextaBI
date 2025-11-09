package questao3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Simulador de Reator Nuclear Iniciado ===\n");
        NuclearReactorContext reator = new NuclearReactorContext();

        // 1. Ligar o reator
        reator.setTemperatura(50);
        reator.monitor(); // Vai para NORMAL

        // 2. Aumentar temperatura para gerar Alerta Amarelo
        System.out.println("\n>>> Aumentando temperatura para 350C...");
        reator.setTemperatura(350);
        reator.monitor(); // Vai para AMARELO

        // 3. Aumentar para crítico e simular passagem de tempo
        System.out.println("\n>>> Temperatura crítica 450C! Aguardando...");
        reator.setTemperatura(450);
        // Simula vários ciclos de monitoramento para passar os 30s
        for (int i = 0; i <= 7; i++) { 
            reator.monitor();
             // Pequena pausa para visualizar a saída se rodar em terminal real (opcional)
             // Thread.sleep(500); 
        }
        // Agora deve estar em VERMELHO

        // 4. Simular falha de pressão para ir para EMERGENCIA
        System.out.println("\n>>> SIMULANDO FALHA DE PRESSÃO (250 bar)...");
        reator.setPressao(250);
        reator.monitor(); // Vai para EMERGENCIA

        // 5. Tentar resfriar (deve voltar para DESLIGADA eventualmente)
        System.out.println("\n>>> Injetando refrigerante de emergência...");
        reator.setTemperatura(80);
        reator.setPressao(20);
        reator.monitor(); // Vai para DESLIGADA
    }
}