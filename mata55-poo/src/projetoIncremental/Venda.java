package projetoIncremental;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
	private Date dataCompra;
	private ArrayList<ItemVenda> produtos;
	private Pessoa funcionario, cliente;
	
	
	public Venda(Pessoa funcionario, Pessoa cliente){
		this.produtos = new ArrayList<ItemVenda>();
		this.funcionario = funcionario;
		this.cliente = cliente;
		dataCompra = new Date();
	}
	public Venda(Pessoa funcionario, String nome, String cpf){
		this(funcionario, new Pessoa(nome, cpf, 'C'));
	}
	
	public void adicionarProduto(Produto produto, int qtd) {
		if(qtd > 0) 
			produtos.add(new ItemVenda(produto, qtd));
		else 
			System.out.println("Quantidade invalida!");
	}
	public void adicionarProduto(Produto produto) {
		adicionarProduto(produto, 1);
	}
	
	public void removerProduto(int codigo) {
		for(int i=0; i<produtos.size();i++) {
			if(produtos.get(i).getProduto().getCodigo() == codigo) {
				produtos.remove(i);
				break;
			}
		}
	}
	public double valorTotal() {
		double valor = 0;
		ItemVenda item;
		for(int i=0;i<produtos.size();i++) {
			item = produtos.get(i);
			valor += item.getProduto().getPreco() * item.getQuantidade();
		}
		return valor;
	}
	
	
	public String registrarCompra(Pessoa cliente, Pessoa funcionario, Produto produto, String dataCompra) {
		String mensagem ="Compra efetuada com sucesso!";
		
		this.funcionario = funcionario;
		this.cliente = cliente;
		
		return mensagem;
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


}