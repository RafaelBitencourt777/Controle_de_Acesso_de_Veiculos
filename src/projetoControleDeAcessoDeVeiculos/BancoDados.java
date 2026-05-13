package projetoControleDeAcessoDeVeiculos;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BancoDados {

	public static DefaultTableModel modeloGlobal = new DefaultTableModel(

		new Object[][] {},
		new String[] {

			"Nome", "CPF", "Marca", "Modelo", "Placa",
			"Cor", "Ano", "Entrada", "Saída", "Valor", "Vaga"

		}

	);

	public static ArrayList<Double> listarValores = new ArrayList<>();

	public static ArrayList<Vaga> listaVagas = new ArrayList<>();

	static {

		for (int i = 1; i <= 300; i++) {

			if (i <= 250) {

				listaVagas.add(new Vaga(i));

			} else {

				listaVagas.add(new VagaPremium(i));

			}

		}

	}

}
