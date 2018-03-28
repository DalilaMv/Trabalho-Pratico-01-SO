import java.util.Collections;
import java.util.List;

public class OrdemChegada extends Ordenador {

    private List<Pedido> pedidos;

    public OrdemChegada(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void simularFila() {

        System.out.println("\n######### Atendimento em Ordem de Chegada #########\n");
        // mostra como a fila ficará
        exibirFila(pedidos);

    }

}
