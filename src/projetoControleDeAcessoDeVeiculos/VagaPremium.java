package projetoControleDeAcessoDeVeiculos;

public class VagaPremium extends Vaga {

	public VagaPremium(int numero) {

		super(numero);

	}

	@Override
	public String tipoVaga() {

		return "Premium";

	}

}
