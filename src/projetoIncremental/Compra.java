package projetoIncremental;

public class Compra {
	private String dataCompra;
	private Produto produto;
	private Pessoa funcionario, cliente;
	private int quantidadeComprada;
	
	public Compra(String dataCompra, Produto produto, Pessoa funcionario, String nomeCliente, String cpfCliente, int quantidadeComprada) {
		this.dataCompra = dataCompra;
		this.produto = produto;
		this.funcionario = funcionario;
		this.quantidadeComprada = quantidadeComprada;
		this.cliente = new Pessoa(nomeCliente, cpfCliente, 'c');
	}
	
	public Compra(String dataCompra, Produto produto, Pessoa funcionario, Pessoa cliente, int quantidadeComprada) {
		this.dataCompra = dataCompra;
		this.produto = produto;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.quantidadeComprada = quantidadeComprada;
	}
	public String registrarCompra(Pessoa cliente, Pessoa funcionario, Produto produto, String dataCompra) {
		String mensagem ="Compra efetuada com sucesso!";
		
		this.dataCompra = dataCompra;
		this.produto = produto;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.quantidadeComprada = 1;
		this.produto.baixaSistema();
		
		return mensagem;
	}
	
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pessoa getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}

}
/*
 * .
Nesta etapa Pessoa, Produto e Compra poderão ser instanciados de modo mais simples, ou
seja, não necessariamente especificando todos os atributos contidos na classe. Pessoa necessitará
apenas nome, cpf e tipo. Produto necessitará apenas de nome e preço, caso não seja especificada a
quantidade no estoque, definir como padrão 0 (zero). Em toda Compra deve ser informado o
Cliente, seja ele cadastrado ou não.
As classes permancerão com todos os atributos descritos na Etapa 1. Utilizar o conceito de
sobrecarga nos métodos construtores para instanciar um objeto passando todos os atributos ou
utilizando apenas os atributos necessários. Repare que Compra possui como atributos Produto e
Pessoas (cliente e funcionário). Um Pessoa do tipo cliente pode ser instanciada em uma Compra ou
já estar cadastrada e ser referenciada. Utilizar os conceitos de composição e sobrecarga para tratar
esses novos incrementos.

*/
