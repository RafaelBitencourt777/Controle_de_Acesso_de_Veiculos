package projetoControleDeAcessoDeVeiculos;

public class Vaga {

	private int numero;
	private boolean ocupada;
	
	public Vaga(int numero) {

		this.numero = numero;
		this.ocupada = false;

	}
	
	public String tipoVaga() {

		return "Comum";

	}

	public int getNumero() {

		return numero;

	}

	public void setNumero(int numero) {

		this.numero = numero;

	}

	public boolean isOcupada() {

		return ocupada;

	}

	public void setOcupada(boolean ocupada) {

		this.ocupada = ocupada;

	}

}