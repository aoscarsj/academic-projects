package bcc.poo.projeto_incremental1;

public class Pessoa {
	private String nome,cpf,dataNascimento,telefone; 
	private char sexo, status, tipoUsuario; 
	
	
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
