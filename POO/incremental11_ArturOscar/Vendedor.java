import java.util.LinkedList;
import java.util.List;

public class Vendedor extends Responsavel{
    private LinkedList<Venda> vendas;
    private double comissao;

    @Override
    public void calculaSalario() {
        for(int i=0; i < vendas.size(); i++)
            comissao += vendas.get(i).valorTotal()*0.2;
        super.setSalario(850 + comissao);
    }

    public Vendedor(String nome, String cpf) {
        super(nome, cpf);
        vendas = new LinkedList<>();
        comissao = 0;
    }

}
