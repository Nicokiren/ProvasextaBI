package questao3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Simulador de Reator Nuclear Iniciado ===\n");
        NuclearReactorContext reator = new NuclearReactorContext();

        
        reator.setTemperatura(50);
        reator.monitor(); // Vai para NORMAL

        
        System.out.println("\n>>> Aumentando temperatura para 350C...");
        reator.setTemperatura(350);
        reator.monitor(); 

        System.out.println("\n>>> Temperatura crítica 450C! Aguardando...");
        reator.setTemperatura(450);
      
        for (int i = 0; i <= 7; i++) { 
            reator.monitor();
             
        }

      
        System.out.println("\n>>> SIMULANDO FALHA DE PRESSÃO (250 bar)...");
        reator.setPressao(250);
        reator.monitor(); 

        
        System.out.println("\n>>> Injetando refrigerante de emergência...");
        reator.setTemperatura(80);
        reator.setPressao(20);
        reator.monitor(); 
    }
}