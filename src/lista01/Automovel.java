package lista01;
/*  01
1. Criar uma classe em Java que represente um autom�vel. � importante guardar o
tipo de combust�vel que ele utiliza (podendo ser gasolina, �lcool, ou flex), o
fabricante, o ano e o modelo. Ser� necess�rio calcular a quantidade de combust�vel
necess�ria para percorrer determinado percurso sabendo-se que: autom�vel a
�lcool faz 15 km/l e autom�vel a gasolina faz 12 km/l. Para aqueles com tipo de
combust�vel flex considerar metade do caminho como gasolina e a outra metade
como �lcool. */

public class Automovel {
	private String fabricante, modelo;
	private int ano; 
	TipoCombustivel tipoCombustivel;
	
	
	public TipoCombustivel getTipo() {
		return tipoCombustivel;
	}

	public void setTipo(TipoCombustivel tipo) {
		this.tipoCombustivel = tipo;
	}

	public double combustivelParaPercurso(double distancia) {
		double quantidade;
		if(this.tipoCombustivel == TipoCombustivel.GASOLINA) 
			quantidade = distancia / 12;
		else if(this.tipoCombustivel == TipoCombustivel.ALCOOL)
			quantidade = distancia / 15;
		else {
			double metadeCaminho = distancia / 2;
			quantidade = metadeCaminho/12 + metadeCaminho/15;
		}
		return quantidade;
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


