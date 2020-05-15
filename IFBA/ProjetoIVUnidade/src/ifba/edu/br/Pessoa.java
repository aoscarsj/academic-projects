package ifba.edu.br;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	
	private static String nome;
	private String CPF, RG, endereco, email, datNascimento, Senha, telefone;
	private char sexo;
	private long matricula;
	private boolean tipo;
	
	protected boolean getTipo() {
		return tipo;
	}

	protected void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	protected String getTelefone() {
		return telefone;
	}

	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getCPF() {
		return CPF;
	}

	protected void setCPF(String cPF) {
		CPF = cPF;
	}

	protected String getRG() {
		return RG;
	}

	protected void setRG(String rG) {
		RG = rG;
	}

	protected String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDatNascimento() {
		return datNascimento;
	}

	public void setDatNascimento(String datNascimento) {
		this.datNascimento = datNascimento;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	//protected abstract long NRegistro();
		
	
	
	
	
	
	
	
	

}
