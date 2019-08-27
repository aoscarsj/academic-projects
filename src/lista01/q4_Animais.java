package lista01;

public class q4_Animais {
	public enum tipoAnimal{
		MAMIFERO, ANFIBIO, AVE;
	}
	private tipoAnimal tipo;
	private String nome;
	private int idade;
	
	public q4_Animais(tipoAnimal tipo, String nome, int idade) {
		this.tipo = tipo;
		this.nome = nome;
		this.idade = idade;
	}

	public tipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(tipoAnimal tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int calcularQtdAlimento(){
		if(this.tipo == tipoAnimal.MAMIFERO) 
			return 2000;
		else if(this.tipo == tipoAnimal.AVE)
			return 100;
		else
			return 20;
	}
	
}