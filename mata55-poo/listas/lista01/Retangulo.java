package bcc.poo.lista01;

public class Retangulo {
	private double comprimento, largura;
	
	public Retangulo(double comprimento, double largura) {
		this.comprimento = comprimento; 
		this.largura = largura;
	}
	public double calcularPerimetro() {
		return (this.comprimento * 2 + this.largura * 2);
	}
	public double calcularPerimetro(Retangulo ret) {
		return (ret.comprimento * 2 + ret.largura * 2);
	}
	public double calcularArea() {
		return (this.comprimento * this.largura);
	}
	public double calcularArea(Retangulo ret) {
		return (ret.comprimento * ret.largura);
	}
	public double getComprimento() {
		return this.comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public double getLargura() {
		return this.largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
}
/*
3. Criar o modelo e implementar em Java uma classe Retângulo. A classe possui os
atributos comprimento e largura. Esta classe deve possuir métodos que calculam o
perímetro e a área do retângulo. A criação da classe deve garantir que comprimento
e largura assumam valores maiores do que 0.
*/