package bcc.poo.projeto_incremental1;

public class Produto {
	private String nome;
	private double preco;
	private int quantidadeNoEstoque;
	
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
/*
Uma loja de roupas de um shopping deseja automatizar seu serviço e sua gestão através de
uma aplicação. Este sistema deverá registrar compras, fazer controle do estoque, gerenciar pessoas e
produtos. Toda Pessoa é representada por nome, cpf, data de nascimento, sexo, telefone, tipo (funcionário ou cliente) e status (ativo ou
inativo). Ao cadastrar uma nova pessoa o status deverá ser por padrão ‘ativo’. Uma Compra possui
a data da compra, o Funcionario que a realizou, o Cliente que está comprando, o Produto e
quantidade do produto a ser comprado. Para essa etapa inicial considere que cada Compra é feita
com apenas 1 Produto.


*/