package ifba.edu.br;

public class QuestoesUni extends Questoes {
	private int altCorreta;

	
	protected int  getAltCorreta() {
		return altCorreta;
	}

	protected void setAltCorreta(int altCorreta) {
		this.altCorreta = altCorreta;
	}

	

	@Override
	protected boolean Corretor(int alternativa) {
		if(alternativa == altCorreta)
			return true;
		else
			return false;
	}

	@Override
	protected void contAcertos() {
		// TODO Auto-generated method stub
		
	}

}
