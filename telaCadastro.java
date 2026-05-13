package projetoControleDeAcessoDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class telaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldPlaca;
	private JTextField textFieldAno;
	private JTextField textFieldEntrada;
	private JTextField textFieldSaida;
	private JTextField textFieldCor;
	private JTextField textFieldVaga;

	private int linhaSelecionada = -1;
	private int vagaAnterior = -1;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					telaCadastro frame = new telaCadastro();
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	public telaCadastro() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 32, 684, 221);

		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 684, 70);

		panel.add(scrollPane);

		table = new JTable();
		table.setModel(BancoDados.modeloGlobal);

		scrollPane.setViewportView(table);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 90, 44, 12);

		panel.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 111, 107, 18);

		panel.add(textFieldNome);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(174, 90, 44, 12);

		panel.add(lblCPF);

		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(174, 111, 78, 18);

		panel.add(textFieldCPF);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(289, 90, 44, 12);

		panel.add(lblMarca);

		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(289, 111, 78, 18);

		panel.add(textFieldMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(408, 90, 60, 12);

		panel.add(lblModelo);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(408, 111, 107, 18);

		panel.add(textFieldModelo);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 139, 44, 12);

		panel.add(lblPlaca);

		textFieldPlaca = new JTextField();
		textFieldPlaca.setBounds(12, 155, 65, 18);

		panel.add(textFieldPlaca);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(174, 139, 44, 12);

		panel.add(lblCor);

		textFieldCor = new JTextField();
		textFieldCor.setBounds(174, 155, 65, 18);

		panel.add(textFieldCor);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(289, 139, 44, 12);

		panel.add(lblAno);

		textFieldAno = new JTextField();
		textFieldAno.setBounds(289, 155, 78, 18);

		panel.add(textFieldAno);
		

		JLabel lblEntrada = new JLabel("Entrada:");
		lblEntrada.setBounds(408, 139, 60, 12);

		panel.add(lblEntrada);

		textFieldEntrada = new JTextField();
		textFieldEntrada.setBounds(408, 155, 120, 18);

		panel.add(textFieldEntrada);

		JLabel lblSaida = new JLabel("Saída:");
		lblSaida.setBounds(554, 139, 44, 12);

		panel.add(lblSaida);

		textFieldSaida = new JTextField();
		textFieldSaida.setBounds(554, 155, 120, 18);

		panel.add(textFieldSaida);
		
		JLabel lblVaga = new JLabel("Vaga:");
		lblVaga.setBounds(549, 90, 44, 12);

		panel.add(lblVaga);

		textFieldVaga = new JTextField();
		textFieldVaga.setBounds(549, 106, 80, 18);

		panel.add(textFieldVaga);

		JButton btnCadastrar = new JButton("Cadastrar");

		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (BancoDados.modeloGlobal.getRowCount() >= 300) {

					JOptionPane.showMessageDialog(null,
							"Estacionamento lotado!");

					return;

				}

				String nome = textFieldNome.getText();
				String cpf = textFieldCPF.getText();
				String marca = textFieldMarca.getText();
				String modelo = textFieldModelo.getText();
				String placa = textFieldPlaca.getText();
				String cor = textFieldCor.getText();
				String ano = textFieldAno.getText();

				String entradaTexto = textFieldEntrada.getText();
				String saidaTexto = textFieldSaida.getText();

				int numeroVaga =
						Integer.parseInt(textFieldVaga.getText());

				if (numeroVaga < 1 || numeroVaga > 300) {

					JOptionPane.showMessageDialog(null,
							"Nenhuma vaga disponível!");

					return;

				}

				Vaga vagaEscolhida =
						BancoDados.listaVagas.get(numeroVaga - 1);

				if (vagaEscolhida.isOcupada()
						&& numeroVaga != vagaAnterior) {

					JOptionPane.showMessageDialog(null,
							"Essa vaga já está ocupada!");

					return;

				}

				DateTimeFormatter formatter =
						DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

				LocalDateTime entrada =
						LocalDateTime.parse(entradaTexto, formatter);

				LocalDateTime saida =
						LocalDateTime.parse(saidaTexto, formatter);

				long minutos =
						Duration.between(entrada, saida).toMinutes();

				long horas = (long) Math.ceil(minutos / 60.0);

				double valor;

				if (horas <= 1) {

					valor = 10;

				} else {

					valor = 10 + (horas - 1) * 3;

				}

				String valorFormatado =
						String.format("R$ %.2f", valor);

				if (linhaSelecionada != -1 && vagaAnterior != numeroVaga) {

					BancoDados.listaVagas
							.get(vagaAnterior - 1)
							.setOcupada(false);

				}
				
				vagaEscolhida.setOcupada(true);

				String vagaNumero =
						vagaEscolhida.getNumero()
						+ " - "
						+ vagaEscolhida.tipoVaga();

				DefaultTableModel listarTabela =
						(DefaultTableModel) table.getModel();

				if (linhaSelecionada == -1) {

					listarTabela.addRow(new Object[] {

						nome,
						cpf,
						marca,
						modelo,
						placa,
						cor,
						ano,
						entradaTexto,
						saidaTexto,
						valorFormatado,
						vagaNumero

					});

					BancoDados.listarValores.add(valor);

				} else {

					listarTabela.setValueAt(nome, linhaSelecionada, 0);
					listarTabela.setValueAt(cpf, linhaSelecionada, 1);
					listarTabela.setValueAt(marca, linhaSelecionada, 2);
					listarTabela.setValueAt(modelo, linhaSelecionada, 3);
					listarTabela.setValueAt(placa, linhaSelecionada, 4);
					listarTabela.setValueAt(cor, linhaSelecionada, 5);
					listarTabela.setValueAt(ano, linhaSelecionada, 6);
					listarTabela.setValueAt(entradaTexto, linhaSelecionada, 7);
					listarTabela.setValueAt(saidaTexto, linhaSelecionada, 8);
					listarTabela.setValueAt(valorFormatado, linhaSelecionada, 9);
					listarTabela.setValueAt(vagaNumero, linhaSelecionada, 10);

					linhaSelecionada = -1;

				}

				textFieldNome.setText("");
				textFieldCPF.setText("");
				textFieldMarca.setText("");
				textFieldModelo.setText("");
				textFieldPlaca.setText("");
				textFieldCor.setText("");
				textFieldAno.setText("");
				textFieldEntrada.setText("");
				textFieldSaida.setText("");
				textFieldVaga.setText("");

			}

		});

		btnCadastrar.setBounds(10, 191, 100, 23);
		panel.add(btnCadastrar);

		JButton btnExcluir = new JButton("Excluir");

		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if (linha != -1) {

					String vagaTexto =
							table.getValueAt(linha, 10).toString();

					int numeroVaga =
							Integer.parseInt(vagaTexto.split(" - ")[0]);

					
					for (Vaga vaga : BancoDados.listaVagas) {

						if (vaga.getNumero() == numeroVaga) {

							vaga.setOcupada(false);

						}

					}

					((DefaultTableModel) table.getModel())
							.removeRow(linha);

				}

			}

		});

		btnExcluir.setBounds(206, 191, 100, 23);
		panel.add(btnExcluir);

		JButton btnEditar = new JButton("Editar");

		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int linha = table.getSelectedRow();

				if (linha != -1) {

					linhaSelecionada = linha;
					
					String vagaTexto =
							table.getValueAt(linha, 10).toString();

					vagaAnterior = Integer.parseInt(vagaTexto.split(" - ")[0]);

					textFieldNome.setText(
							table.getValueAt(linha, 0).toString());

					textFieldCPF.setText(
							table.getValueAt(linha, 1).toString());

					textFieldMarca.setText(
							table.getValueAt(linha, 2).toString());

					textFieldModelo.setText(
							table.getValueAt(linha, 3).toString());

					textFieldPlaca.setText(
							table.getValueAt(linha, 4).toString());

					textFieldCor.setText(
							table.getValueAt(linha, 5).toString());

					textFieldAno.setText(
							table.getValueAt(linha, 6).toString());

					textFieldEntrada.setText(
							table.getValueAt(linha, 7).toString());

					textFieldSaida.setText(
							table.getValueAt(linha, 8).toString());
					
					String vagaTextoEditar =
							table.getValueAt(linha, 10).toString();

					String numeroVaga =
							vagaTextoEditar.split(" - ")[0];

					textFieldVaga.setText(numeroVaga);

				}

			}

		});

		btnEditar.setBounds(380, 191, 100, 23);
		panel.add(btnEditar);

		JButton btnVoltar = new JButton("Voltar");

		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();

			}

		});

		btnVoltar.setBounds(554, 191, 100, 23);
		panel.add(btnVoltar);

		JLabel lblTitulo = new JLabel("Cadastro de Veículos");

		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setBounds(10, 11, 200, 14);

		contentPane.add(lblTitulo);

	}

}