package br.ufba.poo.sip.core;

import java.util.ArrayList;
import java.util.List;


public class Questao {
	private List<Double> notas;
	
	public Questao(){
		notas = new ArrayList<Double>();
	}
	public void cadastrarNota(double nota) {
		notas.add(nota);
	}
	public void cadastrarNota(ArrayList<Double> notas) {
		this.notas.addAll(notas);
	}
	public void removerNota(int index) {
		notas.remove(index);
	}
	
	
}
