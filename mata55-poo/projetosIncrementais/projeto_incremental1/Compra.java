package bcc.poo.projeto_incremental1;

public class Compra {
	private String dataCompra;
	private Produto produto;
	private Pessoa funcionario, cliente;
	private int quantidadeComprada;
	
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
