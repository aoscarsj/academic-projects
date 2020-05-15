package br.ufba.poo.sip.core;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private static int contMatricula = 0;
	
	public Aluno(String nome, String cpf, String rg, String endereco, String email, String datNascimento, String senha,
			String telefone, char sexo) {
		super(nome, cpf, rg, endereco, email, datNascimento, senha, telefone, sexo );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cadastrar() {
		this.setMatricula(gerarMatricula());
		BancoDados.adicionarPessoa(this);
	}

	@Override
	public void remover() {
		BancoDados.removerPessoa(this);
	}

	
	@Override
	public long gerarMatricula() {
		long matricula = super.gerarMatricula();
		matricula += 25130 + Aluno.contMatricula++;
		return matricula;
	}



}
