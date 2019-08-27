package bcc.poo.lista01;
// Questao02
public class Impressora {
	private String fabricante, modelo, tecnologia;
	private int capacidadeImpressao, velocidade;
	
	public Impressora(String fabricante, String modelo, String tecnologia, int capacidadeImpressao, int velocidade) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.tecnologia = tecnologia;
		this.capacidadeImpressao = capacidadeImpressao;
		this.velocidade = velocidade;
	}
	
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
/*2. Criar uma classe em Java que represente uma impressora. Deve-se guardar para
esta, o fabricante, modelo, capacidade de impressão (em número de páginas),
tecnologia (jato tinta ou laser, ou matricial) e velocidade (páginas por segundo). A
classe deve atender aos seguintes itens:
• informar o tempo necessário para imprimir um texto a partir do número de
páginas;
• receber um texto e imprimir (para este método considere a impressão na tela
do texto recebido como se fosse na impressora);
• informar a quantidade de páginas que ainda podem ser impressas com a
carga atual.  */