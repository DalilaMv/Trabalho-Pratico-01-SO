import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

public class FilaPrioridade extends Ordenador{
	 private static List<Pedido> listaProntos = new ArrayList<Pedido>();

	    public FilaPrioridade(List<Pedido> pedido) {
	            preparaListaProntos(pedido);
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


		 public void simularFila() {

		        System.out.println("\n################## Atendimento em Fila de Prioridade ##################\n");
		        // mostra como a fila ficará
		        exibirFila(listaProntos);

		    }

	  
	    
}