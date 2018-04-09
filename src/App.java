import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
    	
    	Arquivo arquivo = new Arquivo();
    	
        System.out.println("Simulador de lavanderia");

       // gravando no arquivo
        List<Pedido> pedidos = new ArrayList<>();

        for (int i=0;i<arquivo.lerTotal();i++) {
        	String[] pedido= arquivo.lerLinha().split(";");
            pedido[2] = pedido[2].replace(",",".");
            Pedido px = new Pedido(pedido[0],Double.parseDouble(pedido[1]),0,Double.parseDouble(pedido[2]));
           
        	pedidos.add(px);
        }
        
    

        //criando uma fila de prioridade 
        FilaPrioridade fp = new FilaPrioridade(pedidos);
        fp.simularFila();
        
        // criando uma fila de menor primeiro
        OrdemMenorPrimeiro menorPrimeiro = new OrdemMenorPrimeiro(pedidos);
        menorPrimeiro.simularFila();
        
        // criando uma fila por ordem de chegada
        OrdemChegada fifo = new OrdemChegada(pedidos);
        fifo.simularFila();

 
    }
}
