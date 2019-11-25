package br.ufba.poo.sip.core;

import java.util.Date;


public abstract class Pessoa implements Cadastro{
	
	private String nome, cpf, rg, endereco, email, datNascimento, senha, telefone;
	private char sexo;
	private long matricula;
	
		
	

	public Pessoa(String nome, String cpf, String rg, String endereco, String email, String datNascimento, String senha,
			String telefone, char sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.email = email;
		this.datNascimento = datNascimento;
		this.senha = senha;
		this.telefone = telefone;
		this.sexo = sexo;
		this.matricula = gerarMatricula();
	}
	
	
	public long gerarMatricula() {
		return (long)new Date().getYear();
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
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
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	
}
