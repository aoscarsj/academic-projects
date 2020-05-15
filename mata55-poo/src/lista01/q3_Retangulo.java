package lista01;

public class q3_Retangulo {
	private double comprimento, largura;
	
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public q3_Retangulo(double comprimento, double largura) {
		this.comprimento = comprimento;
		this.largura = largura;
	}
	public double calcularPerimetro() {
		return (this.comprimento * 2 + this.largura * 2);
	}
	public double calcularPerimetro(q3_Retangulo ret) {
		return (ret.comprimento * 2 + ret.largura * 2);
	}
	public double calcularArea() {
		return (this.comprimento * this.largura);
	}
	public double calcularArea(q3_Retangulo ret) {
		return (ret.comprimento * ret.largura);
	}
}
