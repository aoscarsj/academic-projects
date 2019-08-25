package bcc.poo.lista01;

/*
1. Criar uma classe em Java que represente um autom�vel. � importante guardar o
tipo de combust�vel que ele utiliza (podendo ser gasolina, �lcool, ou flex), o
fabricante, o ano e o modelo. Ser� necess�rio calcular a quantidade de combust�vel
necess�ria para percorrer determinado percurso sabendo-se que: autom�vel a
�lcool faz 15 km/l e autom�vel a gasolina faz 12 km/l. Para aqueles com tipo de
combust�vel flex considerar metade do caminho como gasolina e a outra metade
como �lcool. */

public class Automovel {
	private char tipoCombustivel; // g a f
	private String fabricante, modelo;
	private int ano; 
	
	
	public enum OpcoesMenu {    
	    GASOLINA('g'), ALCOOL('a'), FLEX('f');
	     
	    private final char valor;
	    OpcoesMenu(char valorOpcao){
	        valor = valorOpcao;
	    }
	    public char getValor(){
	        return valor;
	    }
	}
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


