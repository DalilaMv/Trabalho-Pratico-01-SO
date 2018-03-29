import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

public class Round {

	private static final double QUANTUM = 1;
    private static List<Pedido> listaProntos = new ArrayList<Pedido>();
    private static List<Integer> temposChegada = new ArrayList<Integer>();
    
    public Round(List<Pedido> Pedido, String nome) {
        double tempoRetorno = 0;
        
        int totalProcessos = 0;
        for(int i = 0; i < Pedido.size(); i++){
             if(Pedido.get(i).getNome().equals(nome))
                  totalProcessos++;
        }        
        
        double retorno = tempoChegadaMinimo(Pedido);        
        preparaListaProntos(Pedido, retorno);
        System.out.println("\n------------Round-Robin------------");
        
        while (!listaProntos.isEmpty()) {
            Pedido pedido = listaProntos.remove(0);
            
            if (pedido.getDuracao() > QUANTUM) {
                pedido.setDuracao(pedido.getDuracao() - QUANTUM);
                retorno += QUANTUM;
                preparaListaProntos(Pedido, retorno);
                listaProntos.add(pedido);
            }
            else
            {
            	retorno += pedido.getDuracao();
            }
            System.out.println(format("%s - Tempo de espera do primeiro lote: %.1f",pedido.getNome(),retorno));
            if (!listaProntos.contains(pedido)) {
	            tempoRetorno += retorno - pedido.getChegada();
	        }
            //Imprimir o retorno médio
        }
    }
    
    
    private void preparaListaProntos(List<Pedido> pedido, double retorno) {
    	double min = 0;

    	for (Pedido p : pedido) {
			if(!temposChegada.contains(p.getChegada()) && p.getChegada() <= retorno) {
				if(!listaProntos.contains(p)) {
					min = p.getChegada();
        			temposChegada.add((int) min);
					for (Pedido p1 : pedido) {
						if(p1.getChegada() == min)
							listaProntos.add(p1);
					}
				}
			}
		}
    }
    
    
    
    public double tempoChegadaMinimo(List<Pedido> Pedido) {
    	double min = Integer.MAX_VALUE;
    	for (Pedido pedido : Pedido) {
    		if(pedido.getChegada() < min)
    			min = pedido.getChegada();
    	}
    	return min;
    }
}

