package questao04;

public class Imovel {
	private tipoImovel tipo;
	private double area;
	

	public Imovel(double area, tipoImovel tipo) {
		this.area = area;
		this.tipo = tipo;
	}

	public tipoImovel getTipo() {
		return tipo;
	}




	public void setTipo(tipoImovel tipo) {
		this.tipo = tipo;
	}




	public double getArea() {
		return area;
	}




	public void setArea(double area) {
		this.area = area;
	}



	
	public enum tipoImovel{
		CASA(1),APTO(2), OUTROS(3);
		int valor;
		tipoImovel(int valor) {
			this.valor = valor;
		}
	}
}

/*
O cadastro do IPTU é formado por tipo de imóvel (casa, apartamento, etc...), metro quadrado do imóvel, valor do IPTU. O IPTU tem um
beneficiário, 

Para o cálculo do débito do IPTU em 2019 foi definido que cada metro quadrado do imóvel é:
a) Casa será pago R$ 59,76;
b) Apartamento será pago R$ 72,98;
c) E para os outros tipos de imóvel será pago R$ 98,58
Existem diferentes formas de avaliação para recebimento de um benefício de isenção do
pagamento do IPTU. Este beneficio pode ser total ou parcial. A isenção corresponde as
seguintes situações:
a) Quando informado tempo de moradia (em anos) no imóvel. Se este for acima de
10 anos, o beneficiário recebe isenção total;
b) Se o beneficiário tiver prestado serviços para o Estado, recebe 40% de isenção;
c) Para demais casos é usado o salário mínimo atual como teto (1000,00 reais). Se
a renda do beneficiário for menor que o teto é dado 25%, se equivalente, é dado
17% e qualquer renda acima do teto recebe 9% de isenção. */