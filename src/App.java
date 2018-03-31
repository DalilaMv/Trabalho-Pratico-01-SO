import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
    	
    	Arquivo arquivo = new Arquivo();
    	
        System.out.println("Simulador de lavanderia");

        
        // Instanciando os pedidos
        Pedido p1 = new Pedido("Brian Bruno", 35, 0, 10.00);
        Pedido p2 = new Pedido("Dalila Mylena", 25.85, 0, 6.00);
        Pedido p3 = new Pedido("Davi Brandão", 72, 0, 18.00);
        Pedido p4 = new Pedido("João Caram", 10, 0, 5.50);
        Pedido p5 = new Pedido("Lucas Saldanha", 12.85, 0, 17.20);
        Pedido p6 = new Pedido("Sandro Jerônimo <3", 95.88, 0, 25.65);
        Pedido p7 = new Pedido("Teknisa Service", 189.66, 0, 1000.51);
        Pedido p8 = new Pedido("Família Brandão", 50.32, 0, 100.58);

        // Adicionando na lista
       // gravando no arquivo 
        List<Pedido> pedidos = new ArrayList<>();
        arquivo.gravar(p1);
        arquivo.gravar(p2);
        arquivo.gravar(p3);
        arquivo.gravar(p4);
        arquivo.gravar(p5);
        arquivo.gravar(p6);
        arquivo.gravar(p7);
        arquivo.gravar(p8);
     
        for (int i=0;i<arquivo.lerTotal();i++) {
        	String[] pedido= arquivo.lerLinha().split(";");
        	Pedido px = new Pedido(pedido[0],Double.parseDouble(pedido[1]),0,Double.parseDouble(pedido[2]));
           
        	pedidos.add(px);
        }
        
        // criando uma fila por ordem de chegada
        OrdemChegada fifo = new OrdemChegada(pedidos);
        fifo.simularFila();

        // criando uma fila de menor primeiro
        OrdemMenorPrimeiro menorPrimeiro = new OrdemMenorPrimeiro(pedidos);
        menorPrimeiro.simularFila();

    }
}
