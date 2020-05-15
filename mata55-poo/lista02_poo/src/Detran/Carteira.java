package Detran;
/*
Toda carteira de motorista tem um número,
status (se está ativa ou cancelada) e categoria (podendo ser A, B ou C). Uma carteira
pode também acumular pontos.
Dado um determinado condutor, precisamos oferecer para o usuário do sistema a
possibilidade de:
 Será possível instanciar um condutor que já tenha uma carteira, carteira e condutor ao
mesmo tempo, condutor sem carteira.
*/
public class Carteira {
	private long numero;
	private char status;
	private String categoria;
	private int pontos;
	
	
	public Carteira(long numero, String categoria) {
		this.numero = numero;
		this.status = 'a';
		this.categoria = categoria;
		this.pontos = 0;
	}
	public void mudarCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void adicionarCategoria(char categoria) {
		this.categoria += categoria;
	}
	public void adicionarPontos(int quantidade) {
		this.pontos += quantidade;
	}	
	public void adicionarPontos(Carteira carteira, int quantidade) {
		carteira.pontos += quantidade;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
}
