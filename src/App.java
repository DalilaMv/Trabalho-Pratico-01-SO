import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println("Simulador de lavanderia");

        // Instanciando os pedidos
        Pedido p1 = new Pedido("Brian Bruno", 35, 10.00);
        Pedido p2 = new Pedido("Dalila Mylena", 25.85, 6.00);
        Pedido p3 = new Pedido("Davi Brandão", 72, 18.00);
        Pedido p4 = new Pedido("João Caram", 10, 5.50);
        Pedido p5 = new Pedido("Lucas Saldanha", 12.85, 17.20);
        Pedido p6 = new Pedido("Sandro Jerônimo <3", 95.88, 25.65);
        Pedido p7 = new Pedido("Teknisa Service", 189.66, 1000.51);
        Pedido p8 = new Pedido("Família Brandão", 50.32, 100.58);

        // Adicionando na lista
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        pedidos.add(p4);
        pedidos.add(p5);
        pedidos.add(p6);
        pedidos.add(p7);
        pedidos.add(p8);

        // criando uma fila por ordem de chegada
        OrdemChegada fifo = new OrdemChegada(pedidos);
        fifo.simularFila();

        // criando uma fila de menor primeiro
        OrdemMenorPrimeiro menorPrimeiro = new OrdemMenorPrimeiro(pedidos);
        menorPrimeiro.simularFila();

    }
}
