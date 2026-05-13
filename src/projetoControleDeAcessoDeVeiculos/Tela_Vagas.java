package projetoControleDeAcessoDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Vagas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Tela_Vagas frame = new Tela_Vagas();
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * Create the frame.
	 */
	public Tela_Vagas() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Controle de Vagas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 189, 20);

		contentPane.add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 170);

		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(

			new Object[][] {},

			new String[] {

				"Número",
				"Tipo",
				"Status"

			}

		));

		scrollPane.setViewportView(table);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});

		btnVoltar.setBounds(319, 227, 105, 23);

		contentPane.add(btnVoltar);

		carregarVagas();

	}

	public void carregarVagas() {

		DefaultTableModel modelo =
				(DefaultTableModel) table.getModel();

		modelo.setRowCount(0);

		for (Vaga vaga : BancoDados.listaVagas) {

			String status;

			if (vaga.isOcupada()) {

				status = "Ocupada";

			} else {

				status = "Livre";

			}

			modelo.addRow(new Object[] {

				vaga.getNumero(),
				vaga.tipoVaga(),
				status

			});

		}

	}
}
