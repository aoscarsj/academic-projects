package projetoIncremental;

import java.util.Arrays;

public class Pessoa {
	private String nome,cpf,dataNascimento,telefone; 
	private char sexo, status, tipoUsuario; 
	private String []qualidades = {"", "", "", "", ""};
	private byte qtdQualidades = 0;
	
	public void limparVetor() {
		for(int i=0;i<qtdQualidades;i++)
			qualidades[i] = "";
		qtdQualidades = 0;
	}
	public void cadastrarQualidade(String qualidade, int posicao) {
		posicao--;
		if(posicao > 4 || posicao < 0)
			posicao = 0;
		this.qualidades[posicao] = qualidade;
		this.qtdQualidades++;
	}
	public void cadastrarQualidade(String qualidade) {
		int i;
		for(i=0;i<5;i++) 
			if(this.qualidades[i] == "") {
				this.qualidades[i] = qualidade;
				qtdQualidades++;
				break;
			}
		if(i == 5)
			this.qualidades[4] = qualidade;
		
	}
	public void listarQualidades() {
		System.out.println("Qualidades listadas:");
		for(int i=0; i<qtdQualidades; i++) 
			System.out.println(qualidades[i]);
		
	}
	public void listarQualidadesOrdenadas() {
		Arrays.sort(qualidades);
		System.out.println("Qualidades listadas em ordem alfabetica:");
		if(qtdQualidades < 5) 
			qtdQualidades++;
		for(int i=0; i<qtdQualidades; i++) 
			System.out.println(qualidades[i]);
	}
	public Pessoa(String nome, String cpf, char tipoUsuario){
		this.nome = nome;
		this.cpf = cpf;
		this.tipoUsuario = tipoUsuario;
	}
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