import javafx.scene.control.OverrunStyle;
import sun.awt.windows.WSystemTrayPeer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Loja {
	private static Scanner scan;
	private static List<Pessoa>clientes, funcionarios;
	private static List<Produto>produtos;
	private static List<Venda> vendas;

	public static void main(String[] args) {
		new Loja();
		byte opcao=0;
		System.out.println("Antes de Cadastrar uma venda, cadastre pelo menos um vendedor e um produto.");
		do{
			opcao = menu();
			switch (opcao){
				case 1:
					String nome, cpf;
					byte tipoCadastro = scan.nextByte();
					Pessoa cliente;

					System.out.println("1 - Cadastro Simples, 2 - Cadastro Completo");

					System.out.print("Nome do cliente: ");
					nome = scan.nextLine();
					System.out.print("CPF do cliente: ");
					cpf = scan.nextLine();

					if(tipoCadastro == 1)
						cliente = new Pessoa(nome, cpf);
					else{
						String dataNascimento, telefone;
						char sexo;
						System.out.print("Data de Nascimento: ");
						dataNascimento = scan.nextLine();
						System.out.print("Telefone: ");
						telefone = scan.nextLine();
						System.out.print("Sexo (M - Masculino ou F - Feminino): ");
						sexo = scan.next().charAt(0);
						cliente = new Pessoa(nome, cpf, dataNascimento, telefone, sexo);
					}
					clientes.add(cliente);
					System.out.println("Cadastro realizado com sucesso! Retornando ao Menu");
					break;
				case 2:

					break;

				case 3:

					break;

				case 4:
					if(funcionarios.isEmpty() || produtos.isEmpty())
						System.err.println("Antes de Cadastrar uma venda, cadastre pelo menos um vendedor e um produto.");
					else{

					}
					break;
				case 5:
					System.out.println("Fechando aplicação.");
					break;
				default:
					System.out.println("Opcao invalida! Digite novamente.");
					break;
			}
		}while(opcao != 5);
	}

	public static byte menu() {
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Vendedor");
		System.out.println("3 - Cadastrar Produto");
		System.out.println("4 - Cadastrar Venda");
		System.out.println("5 - Sair do Sistema");
		return scan.nextByte();
	}
	public Loja (){
		clientes = new ArrayList<>();
		funcionarios = new ArrayList<>();
		produtos = new ArrayList<>();
		vendas = new LinkedList<>();
		scan = new Scanner(System.in);
	}

}
