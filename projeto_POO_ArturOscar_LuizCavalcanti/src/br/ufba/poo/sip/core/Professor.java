package br.ufba.poo.sip.core;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
	private String disciplina;
	private List<Prova> provasDosAlunos;
	private static int contMatricula = 0;

	public Professor(String nome, String cpf, String rg, String endereco, String email, String datNascimento,
			String senha, String telefone, char sexo, String disciplina) {
		super(nome, cpf, rg, endereco, email, datNascimento, senha, telefone, sexo);
		this.disciplina = disciplina;
		this.provasDosAlunos = new ArrayList<Prova>();
		// TODO Auto-generated constructor stub
	}

	public void cadastrarProva() {

	}

	@Override
	public void cadastrar() {
		this.setMatricula(gerarMatricula());
		BancoDados.adicionarPessoa(this);
	}
	
	@Override
	public long gerarMatricula() {
		long matricula = super.gerarMatricula();
		matricula += 10000 + Professor.contMatricula++;
		return matricula;
	}

	@Override
	public void remover() {
		BancoDados.removerPessoa(this);
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}
