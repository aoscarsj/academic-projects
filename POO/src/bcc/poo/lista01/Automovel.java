package bcc.poo.lista01;

/*
1. Criar uma classe em Java que represente um automóvel. É importante guardar o
tipo de combustível que ele utiliza (podendo ser gasolina, álcool, ou flex), o
fabricante, o ano e o modelo. Será necessário calcular a quantidade de combustível
necessária para percorrer determinado percurso sabendo-se que: automóvel a
álcool faz 15 km/l e automóvel a gasolina faz 12 km/l. Para aqueles com tipo de
combustível flex considerar metade do caminho como gasolina e a outra metade
como álcool. */

public class Automovel {
	private char tipoCombustivel; // g a f
	private String fabricante, modelo;
	private int ano; 
	
	public double combustivelParaPercurso(double distancia) {
		double quantidade;
		if(this.tipoCombustivel == 'g') 
			quantidade = distancia / 12;
		else if(this.tipoCombustivel == 'a')
			quantidade = distancia / 15;
		else {
			double metadeCaminho = distancia / 2;
			quantidade = metadeCaminho/12 + metadeCaminho/15;
		}
		return quantidade;
	}

	public char getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(char tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}


