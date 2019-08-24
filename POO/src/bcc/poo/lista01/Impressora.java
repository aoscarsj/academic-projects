package bcc.poo.lista01;
// 
public class Impressora {
	private String fabricante, modelo, tecnologia;
	private int capacidadeImpressao, velocidade;
	
	public int tempoParaImpressao(int numeroPaginas) {
		return (this.velocidade * numeroPaginas);
	}
	public void imprimir(String documento) {
		System.out.println(documento);
		capacidadeImpressao--;
	}
	public int quantidadePaginasImprimiveis() {
		return capacidadeImpressao;
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
	public String getTecnologia() {
		return tecnologia;
	}
	//teste tes
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public int getCapacidadeImpressao() {
		return capacidadeImpressao;
	}
	public void setCapacidadeImpressao(int capacidadeImpressao) {
		this.capacidadeImpressao = capacidadeImpressao;
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
}
/* 2.
Criar uma classe em Java que represente uma impressora. Deve-se guardar para
esta, o fabricante, modelo, capacidade de impress�o (em n�mero de p�ginas),
tecnologia (jato tinta ou laser, ou matricial) e velocidade (p�ginas por segundo). A
classe deve atender aos seguintes itens:
� informar o tempo necess�rio para imprimir um texto a partir do n�mero de
p�ginas;
� receber um texto e imprimir (para este m�todo considere a impress�o na tela
do texto recebido como se fosse na impressora);
� informar a quantidade de p�ginas que ainda podem ser impressas com a
carga atual. */