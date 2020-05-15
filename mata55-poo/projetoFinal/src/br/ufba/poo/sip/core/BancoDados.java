package br.ufba.poo.sip.core;

import java.util.ArrayList;

public class BancoDados {
	private static ArrayList<Aluno> alunos;
	private static ArrayList<Professor> professores;
	private static ArrayList<Disciplina> disciplinas;
	private static int qtdUsuarios;
	
	BancoDados(){
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		disciplinas = new ArrayList<Disciplina>();
		qtdUsuarios = 0;
		apresentacaoProjeto();
	}
	
	private void apresentacaoProjeto() {
		Aluno aluno1 = new Aluno("Artur Oscar", "888.888.888-88", "1224568-88", "Av. Adhemar de Barros, S/N", "arturoscar@teste.com", "12/01/2010", "123456", "4004-2021", 'M');
		Aluno aluno2 = new Aluno("Luiz Cavalcanti", "999.999.999-99", "1000000-88", "Salvador - BA", "luiz.cavalcanti@teste.com", "12/01/2000", "654321", "4004-4021", 'M');
		Professor professora = new Professor("Fernanda Souza", "777.777.777-77", "20000000-22", "Salvador - BA", "fernanda.teste@usp.br", "01/01/1970", "111111", "1213-4544", 'F', "Programação Orientada a Objetos");
		Professor professor = new Professor("Rodrigo Santos", "666.666.666-66", "2321000-22", "Sao Paulo - SP", "rodrigo.teste@usp.br", "01/01/1970", "222222", "1213-4544", 'F', "Laboratório de Programação");
		Professor prof = new Professor("Rodrigo Silva", "123", "2321000-22", "Sao Paulo - SP", "rodrigo.teste@usp.br", "01/01/1970", "123", "1213-4544", 'F', "Teste de Programação");
		Aluno alun = new Aluno("Luiz Santos", "456", "1224568-88", "Av. Adhemar de Barros, S/N", "arturoscar@teste.com", "12/01/2010", "456", "4004-2021", 'M');

		adicionarPessoa(aluno1);
		adicionarPessoa(aluno2);
		adicionarPessoa(professora);
		adicionarPessoa(professor);
		adicionarPessoa(prof);
		adicionarPessoa(alun);

	}
	
	public static void adicionarPessoa(Pessoa pessoa) throws PessoaNaoEncontradaException {
		if(pessoa instanceof Aluno)
			alunos.add((Aluno)pessoa);
		else if (pessoa instanceof Professor) 
			professores.add((Professor)pessoa);
		else 
			throw new PessoaNaoEncontradaException();
		qtdUsuarios++;
	}
	public static void removerPessoa(Pessoa pessoa) throws PessoaNaoEncontradaException {
		if(pessoa instanceof Aluno)
			alunos.remove((Aluno)pessoa);
		else if (pessoa instanceof Professor)
			professores.remove((Professor)pessoa);
		else 
			throw new PessoaNaoEncontradaException();
		qtdUsuarios--;
	}
	public static void removerAluno(int index) {
		alunos.remove(index);
		qtdUsuarios--;
	}
	public static void removerProfessor(int index) {
		professores.remove(index);
		qtdUsuarios--;
	}
	
	public static boolean buscarPessoa(Pessoa pessoa) {
		boolean encontrada = false;
		if(pessoa instanceof Aluno) {
			for(int i =0 ; i< alunos.size(); i++) 
				if(alunos.get(i).equals(pessoa)) {
					encontrada = true;
					break;
				}
		}
		else if (pessoa instanceof Professor) {
			for(int i = 0; i< professores.size(); i++) 
				if(professores.get(i).equals(pessoa)) {
					encontrada = true;
					break;
				}
		}
		return encontrada;
	}
	public static Pessoa buscarPessoa(String cpf) throws PessoaNaoEncontradaException {
		Pessoa pessoa = null;
		boolean achou = false;
		
		for(int i =0 ; i< alunos.size(); i++) 
			if(alunos.get(i).getCpf().equals(cpf)) {
				pessoa = alunos.get(i);
				achou = true;
				break;
		}
		if(!achou) {
			for(int i = 0; i< professores.size(); i++) 
				if(professores.get(i).getCpf().equals(cpf)) {
					pessoa = professores.get(i);
					achou = true;
					break;
				}
		}
		if(!achou) 
			throw new PessoaNaoEncontradaException();
		return pessoa;
	}
	public static boolean buscarPorCPF(String cpf) throws PessoaNaoEncontradaException {
		boolean achou = false;
		
		for(int i =0 ; i< alunos.size(); i++) 
			if(alunos.get(i).getCpf().equals(cpf)) {
				achou = true;
				break;
		}
		if(!achou) {
			for(int i = 0; i< professores.size(); i++) 
				if(professores.get(i).getCpf().equals(cpf)) {
					achou = true;
					break;
				}
		}
		if(!achou) 
			throw new PessoaNaoEncontradaException();
		return achou;
	}
	
	public static ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public static void setAlunos(ArrayList<Aluno> alunos) {
		BancoDados.alunos = alunos;
	}
	public static ArrayList<Professor> getProfessores() {
		return professores;
	}
	public static void setProfessores(ArrayList<Professor> professores) {
		BancoDados.professores = professores;
	}
	public static ArrayList<Disciplina> getTurmas() {
		return disciplinas;
	}
	public static void setTurmas(ArrayList<Disciplina> turmas) {
		BancoDados.disciplinas = turmas;
	}
	public static int getQtdUsuarios() {
		return qtdUsuarios;
	}
	public static void setQtdUsuarios(int qtdUsuarios) {
		BancoDados.qtdUsuarios = qtdUsuarios;
	}
}
