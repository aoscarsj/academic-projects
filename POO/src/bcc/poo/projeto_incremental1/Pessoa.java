package bcc.poo.projeto_incremental1;

public class Pessoa {
	private String nome,cpf,dataNascimento,telefone; //func ou cliente
	private char sexo, status, tipoUsuario; //ativo ou inativo
	//status : Funcionario ou cliente
	
	public Pessoa(String nome, String cpf, String dataNascimento, String telefone, char tipoUsuario, char sexo){
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
		this.sexo = sexo;
		this.status = 'a';
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public char getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(char tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
/*
Uma loja de roupas de um shopping deseja automatizar seu serviço e sua gestão através de
uma aplicação. 
Este sistema deverá registrar compras, fazer controle do estoque, gerenciar pessoas e
produtos. 
 Ao cadastrar uma nova pessoa o status deverá ser por padrão ‘ativo’. Uma Compra possui
a data da compra, o Funcionario que a realizou, o Cliente que está comprando, o Produto e
quantidade do produto a ser comprado. Para essa etapa inicial considere que cada Compra é feita
com apenas 1 Produto.


*/