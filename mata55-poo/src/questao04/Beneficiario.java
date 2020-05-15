package questao04;

import questao04.Imovel.tipoImovel;

public class Beneficiario {
	private String nome, RG, CPF;
	private double rendaMensal;
	private Imovel imovel;
	
	public Beneficiario(String nome, String RG) {
		this.nome = nome;
		this.RG = RG;
		this.rendaMensal = -1;
		
	}
	public Beneficiario(String nome, String RG, String CPF, double rendaMensal, Imovel imovel) {
		this.nome = nome;
		this.RG = RG;
		this.CPF = CPF;
		this.rendaMensal = rendaMensal;
		this.imovel = imovel;
	}
	public double calculoIPTU() {
		double valor;
		if(this.imovel.getTipo() == tipoImovel.CASA) 
			valor = 59.76;
		else if(this.imovel.getTipo() == tipoImovel.APTO)
			valor = 72.98;
		else
			valor = 98.58;
		valor *= this.imovel.getArea();
		return calculaDesconto(valor);
		
	}
	public double calculaDesconto(double valor) {
		if(rendaMensal < 1000)
			valor *= 0.75;
		else if(rendaMensal == 1000)
			valor *= 0.83;
		else
			valor *= 0.91;
		return valor;
		
	}
	public double calculoIPTU(int anos) {
		double valor = calculoIPTU();
		if(anos >= 10)
			valor = 0;
		return valor;
	}
	public double calculoIPTU(boolean prestouServicos) {
		double valor = calculoIPTU();
		if(prestouServicos)
			valor *= 0.6;
		return valor;
	}

}
