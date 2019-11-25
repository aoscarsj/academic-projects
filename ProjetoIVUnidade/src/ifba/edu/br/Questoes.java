package ifba.edu.br;

public abstract class Questoes {
	private String Materia, Professor, Pergunta;
	private String [] Alternativas = new String [5];
	private int Dificuldade;
	
	
	//protected abstract void tipoQuestao();
	protected abstract boolean Corretor(int alternativa);
	protected abstract void contAcertos();
	
	
	
	
	public String getMateria() {
		return Materia;
	}
	public void setMateria(String materia) {
		Materia = materia;
	}
	public String getProfessor() {
		return Professor;
	}
	public void setProfessor(String professor) {
		Professor = professor;
	}
	public String getPergunta() {
		return Pergunta;
	}
	public void setPergunta(String pergunta) {
		Pergunta = pergunta;
	}
	public String[] getAlternativas() {
		return Alternativas;
	}
	public void setAlternativas(String[] Alternativas) {
		this.Alternativas = Alternativas;
	}
	public int getDificuldade() {
		return Dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		Dificuldade = dificuldade;
	}

}
