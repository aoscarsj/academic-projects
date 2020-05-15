package br.ufba.poo.sip.core;

import java.util.ArrayList;
import java.util.List;

public class Prova {
	private List<Double> notas;
	private Aluno aluno;
	
	
	public Prova(List<Double> notas, Aluno aluno) {
		this.notas = notas;
		this.aluno = aluno;
	}
	public Prova(Aluno aluno) {
		this.aluno = aluno;
		this.notas = new ArrayList<Double>();
	}
	
	protected void cadastrarNota(double nota) {
		this.notas.add(nota);
	}
	protected void cadastrarNota(List<Double> notas) {
		this.notas.addAll(notas);
	}
	
	public List<Double> getNotas() {
		return notas;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
	
	
}
