import java.util.Arrays;

public abstract class Funcionario extends Pessoa {
	private String []qualidades = {"", "", "", "", ""};
	private char status;
	private byte qtdQualidades = 0;
	private double salario;



	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf) {
		super(nome, cpf);
		this.salario = 1000;
		// TODO Auto-generated constructor stub
	}
	public void limparVetor() {
		for(int i=0;i<qtdQualidades;i++)
			qualidades[i] = "";
		qtdQualidades = 0;
	}
	public void cadastrarQualidade(String qualidade, int posicao) {
		posicao--;
		if(posicao > 4 || posicao < 0)
			posicao = 0;
		this.qualidades[posicao] = qualidade;
		this.qtdQualidades++;
	}
	public void cadastrarQualidade(String qualidade) {
		int i;
		for(i=0;i<5;i++) 
			if(this.qualidades[i] == "") {
				this.qualidades[i] = qualidade;
				qtdQualidades++;
				break;
			}
		if(i == 5)
			this.qualidades[4] = qualidade;
		
	}

	
	public void listarQualidades() {
		System.out.println("Qualidades listadas:");
		for(int i=0; i<qtdQualidades; i++) 
			System.out.println(qualidades[i]);
		
	}
	public void listarQualidadesOrdenadas() {
		Arrays.sort(qualidades);
		System.out.println("Qualidades listadas em ordem alfabetica:");
		if(qtdQualidades < 5) 
			qtdQualidades++;
		for(int i=0; i<qtdQualidades; i++) 
			System.out.println(qualidades[i]);
	}

}
