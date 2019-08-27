package lista01;
/*
 * Criar o modelo e implementar em Java uma classe Aluno. A classe possui os
atributos nome, ano de ingresso, curso e qtd de disciplinas aprovadas. Esta classe
deve possuir os seguintes métodos:
• método para calcular o número de créditos do aluno, sabendo-se que cada
disciplina aprovada representa 4 créditos
• método para calcular o tempo (em anos) de permanência do aluno na
faculdade
 * 
 */
public class Aluno {
	private String nome, curso;
	private int anoIngresso, quantidadeDisciplinasAprovadas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	public int getQuantidadeDisciplinasAprovadas() {
		return quantidadeDisciplinasAprovadas;
	}
	public void setQuantidadeDisciplinasAprovadas(int quantidadeDisciplinasAprovadas) {
		this.quantidadeDisciplinasAprovadas = quantidadeDisciplinasAprovadas;
	}
	public int calcularTempoPermanencia() {
		return (2019 - this.anoIngresso);
	}
	public int calcularCreditos() {
		return (this.quantidadeDisciplinasAprovadas * 4);
		
	}
}
