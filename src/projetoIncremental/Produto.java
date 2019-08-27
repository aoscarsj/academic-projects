package projetoIncremental;

public class Produto {
	private String nome;
	private double preco;
	private int quantidadeNoEstoque;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeNoEstoque = 0;
	}
	public Produto(String nome, double preco, int quantidadeEstoque) {
		this.nome = nome;
		this.preco = preco;
		this.quantidadeNoEstoque = quantidadeEstoque;
	}
	public void baixaSistema() {
		this.quantidadeNoEstoque--;
	}
	public void adicionarEstoque(int quantidade) {
		this.quantidadeNoEstoque+= quantidade;
	}
	public void removerEstoque(int quantidade) {
		this.quantidadeNoEstoque -= quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidadeNoEstoque() {
		return quantidadeNoEstoque;
	}
	public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
		this.quantidadeNoEstoque = quantidadeNoEstoque;
	}
	
}
