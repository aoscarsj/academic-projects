package ifba.edu.br;

import java.util.ArrayList;

public class BaseDados {
	
	private static ArrayList <Pessoa> Pessoas = new ArrayList <Pessoa> ();
	private static ArrayList <Questoes> questoes = new ArrayList <Questoes> ();
	//private static ArrayList <Long> LoginProf = new ArrayList<Long>();
	//private static ArrayList <Long> LoginAluno = new ArrayList<Long>();

	
	protected static ArrayList<Pessoa> getPessoas() {
		return Pessoas;
	}

	protected static void setPessoas(Pessoa pessoa) {
		Pessoas.add(pessoa);
	}


	
		
			
		
		
	

}
