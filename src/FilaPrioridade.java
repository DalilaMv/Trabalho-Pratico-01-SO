import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

public class FilaPrioridade{
	 private static List<Pedido> listaProntos = new ArrayList<Pedido>();

	    public FilaPrioridade(List<Pedido> pedido) {
	        try {
	        	double retornoMedio = 0;
	            double tempoRetorno = 0;
	            int totalProcessos = pedido.size();
	            double retorno = 0;
	            preparaListaProntos(pedido);
	            System.out.println("\n------------Fila de Prioridade------------");
	    
				while (!listaProntos.isEmpty()) {
					Pedido p = listaProntos.remove(0); 
					retorno += p.getDuracao();
					tempoRetorno += retorno;
					System.out.println(format("%s - Tempo de espera do primeiro lote: %.1f",p.getNome(),retorno));
				}

	    
	           retornoMedio = tempoRetorno/totalProcessos;
	           System.out.print(format("\ntempo medio - %.1f", retornoMedio));
	          
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    }
	    
	
		private void preparaListaProntos(List<Pedido> pedido) {
			List<Pedido> p = new ArrayList<Pedido>(pedido);
			int maior = 0;
			int pivo = 0;
		

			while(p.size() > 1) {
				pivo = 0;
				for(int i = 1; i < p.size(); i++) {
					if(p.get(pivo).getPreco() >= p.get(i).getPreco())
						maior = pivo;
					else {
						pivo = i;
						maior = i;
					}
				}
				listaProntos.add(p.remove(maior));
			}

			if(p.size() == 1)
				listaProntos.add(p.remove(0));
	    }

	  
	    
}