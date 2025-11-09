package questao4;

public class Main {
    public static void main(String[] args) {
        NFeProcessor processor = new NFeProcessor();

        processor.process(new NFeDocument("NF-1234", 1500.00));

        
        processor.process(new NFeDocument("NF-5000", 5000.00));

     
        processor.process(new NFeDocument("NF-9999", 100.00));
    }
}