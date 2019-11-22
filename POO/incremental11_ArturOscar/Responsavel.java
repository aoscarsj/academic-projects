public abstract class Responsavel extends Funcionario{

    public Responsavel(String nome, String cpf) {
        super(nome, cpf);
    }
    public abstract void calculaSalario();
}
