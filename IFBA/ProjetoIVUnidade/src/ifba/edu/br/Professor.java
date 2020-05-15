package ifba.edu.br;

public class Professor extends Pessoa {
	
	private static String Materia;
	protected int tipo = 2;

	Professor() {
			super.setTipo(true);	
	}
	
	
	


	protected String getMateria() {
		return Materia;
	}






	protected void setMateria(String materia) {
		Materia = materia;
	}






	/*protected long NRegistro() {
		NRegistro = getNRegistroProf();
		NRegistro++;
		setNRegistroProf(NRegistro);
		return NRegistro;
	}*/

	
	

}
