public class Pedido implements Comparable<Pedido> {

    private static int pedidos = 0;
    private int id;
    private String nome;
    private double peso;
    private double chegada;
    private double preco;
    private double duracao;
    private double duracaoRestante;

    public Pedido(String nome, double peso,  double chegada, double preco) {
        this.nome = nome;
        this.peso = peso;
        this.chegada = chegada;
        this.preco = preco;
        this.duracao = peso/35;
        this.id = ++pedidos;
        this.duracaoRestante = this.duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getChegada() {
        return peso;
    }

    public void setChegada(double chegada) {
        this.chegada = chegada;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Pedido pedido) {
        int retorno = 0;
        if (pedido.getPeso() > getPeso()) {
            retorno = -1;
        } else if (pedido.getPeso() < getPeso()){
            retorno = 1;
        }

        return retorno;
    }

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public double getDuracaoRestante() {
		return duracaoRestante;
	}

	public void setDuracaoRestante(double duracaoRestante) {
		this.duracaoRestante = duracaoRestante;
	}
}
