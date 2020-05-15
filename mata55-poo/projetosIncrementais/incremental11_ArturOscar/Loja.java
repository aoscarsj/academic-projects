
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
			scan.next();
			switch (opcao){
				case 1:
					clientes.add(cadastrarCliente());
					System.out.println("Cadastro realizado com sucesso! Retornando ao Menu");
					break;
				case 2:
					String qualidades;
					System.out.print("Informe a função do funcionário ('c' - Caixa | 'v' - vendedor | 'g' - gerente): " );

					Funcionario func = cadastrarFuncionario(scan.next().charAt(0));

					System.out.print("Informe cinco qualidades do funcionário: ");
					for(int i=0;i < 5; i++)
						func.cadastrarQualidade(scan.nextLine());
					funcionarios.add(func);
					System.out.println("Cadastro realizado com sucesso! Retornando ao Menu");
					break;

				case 3:
					String nome;
					double preco;
					int codigo;

					System.out.print("Nome do produto: ");
					nome = scan.nextLine();
					System.out.print("Preco do produto: ");
					preco = scan.nextDouble();
					System.out.print("Codigo do produto: ");
					codigo = scan.nextInt();
					scan.next();
					produtos.add(new Produto(nome,preco,codigo));
					break;

				case 4:
					if(funcionarios.isEmpty() || produtos.isEmpty())
						System.err.println("Antes de Cadastrar uma venda, cadastre pelo menos um vendedor e um produto.");
					else{
						String cpf;
						Pessoa cliente = null, funcionario = null;
						Produto produto = null;
						int cod,qtd;
						boolean pessoaEncontrada = false, prodEncontrado = false;
						// validate para cliente
						do {
							System.out.print("CPF do cliente: ");
							cpf = scan.nextLine();
							for(int i =0 ; i<clientes.size();i++)
								if(clientes.get(i).getCpf().equals(cpf)){
									pessoaEncontrada = true;
									cliente = clientes.get(i);
									break;
								}
							if(!pessoaEncontrada)
								System.err.println("Cliente não encontrado. Por favor, informe um CPF cadastrado no sistema.");
						}while(pessoaEncontrada);
						// validate para funcionario
						do{
							System.out.print("CPF do vendedor: ");
							cpf = scan.nextLine();
							for(int i =0 ; i<funcionarios.size();i++)
								if(funcionarios.get(i).getCpf().equals(cpf)){
									if( !(funcionarios.get(i) instanceof Responsavel))
										continue;
									pessoaEncontrada = true;
									funcionario = funcionarios.get(i);
									break;
								}
							if(!pessoaEncontrada)
								System.err.println("Funcionario não encontrado ou não é responsável por venda Por favor, informe um CPF cadastrado no sistema.");
						}while(pessoaEncontrada);

						Venda venda = new Venda((Responsavel)funcionario, cliente);

						byte continuar;
						do {
							do {
								continuar = 0;
								prodEncontrado = false;
								System.out.print("Informe o codigo do produto: ");
								cod = scan.nextInt();
								scan.next(); // Para evitar problemas com o buffer
								for (int i = 0; i < produtos.size(); i++)
									if (produtos.get(i).getCodigo() == cod) {
										prodEncontrado = true;
										produto = produtos.get(i);
										break;
									}
								if (!prodEncontrado)
									System.err.println("Produto não encontrado. Por favor, informe um codigo cadastrado no sistema.");
							} while (prodEncontrado);
							System.out.print("Quantidade do produto: ");
							qtd = scan.nextInt();
							venda.adicionarProduto(produto, qtd);
							System.out.print("Adicionar mais produtos? (1 - Sim | 2 - Nao): ");
							continuar = scan.nextByte();
							scan.next(); // Para evitar problemas com o buffer

						}while(continuar == 1);
						vendas.add(venda);
						System.out.println("Venda cadastrada com sucesso!");
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
	public static Funcionario cadastrarFuncionario(char funcao){
		Funcionario func = (Funcionario)cadastrarCliente();
		if(funcao == 'c')
			func = (Caixa)func;
		else if(funcao == 'v')
			func = (Vendedor)func;
		else
			func = (Gerente)func;
		return func;
	}
	public static Pessoa cadastrarCliente(){
		String nome, cpf;
		Pessoa cliente;

		System.out.println("1 - Cadastro Simples, 2 - Cadastro Completo");
		byte tipoCadastro = scan.nextByte();
		scan.next(); // Para evitar problemas com o buffer

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
		return cliente;
	}

	public static byte menu() {
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Funcionario");
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
