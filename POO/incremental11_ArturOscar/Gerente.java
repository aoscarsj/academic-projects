import java.util.LinkedList;

public class Gerente extends Responsavel{
    private LinkedList<Venda> vendas;
    private double comissao;

    public Gerente(String nome, String cpf) {
        super(nome, cpf);
        vendas = new LinkedList<>();
        comissao = 0;
    }

    @Override
    public void calculaSalario() {
        for(int i=0; i<vendas.size(); i++)
            comissao += vendas.get(i).valorTotal() * 0.1;
        super.setSalario(2000 + comissao);
    }
}
