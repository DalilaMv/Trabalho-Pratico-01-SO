import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {

		
	List<Pedido> listaPedidos = new ArrayList<Pedido>();
	Scanner teclado = new Scanner(System.in);
	        String lixo;
	        int op = 0;
	        String nome;
	        int peso;
	        double preco;
	        
	        do{
	            System.out.println("");
	            System.out.println("*-- SELECIONE UMA OPÇÃO --*");
	            System.out.println("[1] - Registrar um Pedido do Cliente.");
	            System.out.println("[2] - Simulação.");
	            System.out.println("[0] - Sair.");
	            System.out.print("-> ");   
	            try{
	                op = teclado.nextInt();
	                System.out.println("");
	            }catch(InputMismatchException e){
	                lixo = teclado.nextLine();
	                System.out.println("--------------------------------------------");
	                System.out.println("**Valor inválido!");
	                System.out.println("--------------------------------------------");
	            }
	            
	            switch(op){
	                case 1:
	                    lixo = teclado.nextLine();
	                    System.out.println("Digite o nome do Cliente: ");
	                    System.out.print("-> ");
	                    nome = teclado.nextLine();
	                    System.out.println("Digite o peso em KG: ");
	                    System.out.print("-> ");                    
	                    peso = teclado.nextInt();
	                    System.out.println("Digite o preco: ");
	                    System.out.print("-> ");        
	                    preco = teclado.nextDouble();
	                    Pedido c = new Pedido(nome,peso,preco);
	listaPedidos.add(c);
	                    break;
	                    
	                case 2:
	                           FilaPrioridade fp = new FilaPrioridade(listaPedidos);
	                   break;
	                   
	                case 0:
	                    break;
	                default:
	                    System.out.println("--------------------------------------------");
	                    System.out.println("**Opção Inválida!");
	                    System.out.println("--------------------------------------------");
	                    break;
	                
	            }
	        }while(op != 0);
}
}