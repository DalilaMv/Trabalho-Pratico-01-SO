import java.util.Collections;
import java.util.List;

public class OrdemMenorPrimeiro extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemMenorPrimeiro(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        // ordena os pedidos, pois é o menor primeiro. Para isso, o pedido se tornou "Comparable"
        ordenarPedidos(pedidos);
    }

    public void simularFila() {

        System.out.println("\n######### Atendimento em Ordem de Menor Primeiro #########\n");
        // mostra como a fila ficará
        exibirFila(pedidos);

    }
}
