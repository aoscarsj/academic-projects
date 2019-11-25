package ifba.edu.br;

public class Aluno extends Pessoa{

	private String Serie;
	private String Curso;
	protected int tipo = 1;
	
	Aluno(){
		super.setTipo(false);
			}
	
		public String getSerie() {
		return Serie;
	}

	public void setSerie(String serie) {
		Serie = serie;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

}
