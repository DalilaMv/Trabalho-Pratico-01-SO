import java.util.Collections;
import java.util.List;

public class Ordenador {

    public double calcularTempo (Pedido pedido) {
        return (pedido.getPeso()*60)/35;
    }

    public String formatarTempo (int valor) {
        int inteira = valor / 60;
        int resto = valor % 60;
        return String.format("%2s", inteira).replace(' ', '0') + "h:" + String.format("%-2s", resto).replace(' ', '0');
    }

    public void exibirFila (List<Pedido> pedidos) {

        if(pedidos.size() > 0) {
            double tempoTotal = 0;
            double tempoResposta = 0;

            for (Pedido pedido : pedidos) {
                double tempoLavagem = calcularTempo(pedido);

                System.out.println("#ID: " + pedido.getId());
                System.out.println("Cliente: " + pedido.getNome());
                System.out.println("Tempo esperando na fila: " + formatarTempo((int) tempoTotal) + " Tempo de lavagem: " + formatarTempo((int) tempoLavagem) + "\n");

                // calcula o tempo de resposta desse pedido
                tempoResposta = tempoResposta + tempoTotal;
                // calcula o tempo total que a fila está em execução
                tempoTotal = tempoTotal + tempoLavagem;
            }

            System.out.println("Tempo total: " + formatarTempo((int) tempoTotal));
            System.out.println("Tempo médio aproximado de resposta: " + formatarTempo((int) tempoResposta / pedidos.size()));
        }
    }

    public void ordenarPedidos(List<Pedido> pedidos){
        Collections.sort(pedidos);
    }
}
