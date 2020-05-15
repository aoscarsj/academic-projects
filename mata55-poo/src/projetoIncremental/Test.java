package projetoIncremental;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Venda c = new Venda(new Pessoa("Artur", "123", 'F'), new Pessoa("Oscar", "456", 'C'));
		Produto p = new Produto(123);
		Produto q = new Produto(456);
		Produto r = new Produto(100);
		p.setPreco(100);
		q.setPreco(1000);
		r.setPreco(99);
		c.adicionarProduto(p);
		c.adicionarProduto(q, 10);
		c.adicionarProduto(r, 0);
		System.out.println(c.valorTotal());
	}

}
