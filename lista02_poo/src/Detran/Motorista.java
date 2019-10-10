package Detran;

public class Motorista {
	private String nome, CPF;
	private Carteira carteira;
	
	public Motorista(String nome, String CPF, Carteira carteira) {
		this.nome = nome;
		this.CPF = CPF;
		this.carteira = carteira;
	}
	public Motorista(String nome, String CPF) {
		this.nome = nome;
		this.CPF = CPF;
		this.carteira = null;
	}
}
/*
 * 1. Considere que o Detran precisa de um sistema para controlar a carteira de motorista
de
um determinado condutor. Em nosso problema hipotético, cada possível condutor
deverá
ter informações relacionadas ao seu nome, identificação (RG ou CPF, por exemplo) e a
carteira de motorista a qual lhe pertence. Toda carteira de motorista tem um número,
status (se está ativa ou cancelada) e categoria (podendo ser A, B ou C). Uma carteira
pode também acumular pontos.
Dado um determinado condutor, precisamos oferecer para o usuário do sistema a
possibilidade de:
a. modificar a categoria da carteira;
b. inclusão de pontos em sua carteira;
c. consulta dos pontos atuais da carteira; e
d. verificar se a carteira
Será possível instanciar um condutor que já tenha uma carteira, carteira e condutor ao
mesmo tempo, condutor sem carteira.
*/
