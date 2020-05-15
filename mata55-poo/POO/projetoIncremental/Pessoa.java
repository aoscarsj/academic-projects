//package projetoIncremental;

import java.util.Arrays;

public class Pessoa {
	private String nome,cpf,dataNascimento,telefone; 
	private char sexo; 
	private static int pessoasCriadas = 0;
	private int idUnico;
	public Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
		idUnico = ++pessoasCriadas;
	}
	public Pessoa(String nome, String cpf, String dataNascimento, String telefone, char sexo){
		this(nome, cpf);
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.sexo = sexo;
	}
	public int getIdUnico() {
		return idUnico;
	}
	public void setIdUnico(int idUnico) {
		this.idUnico = idUnico;
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
	
}