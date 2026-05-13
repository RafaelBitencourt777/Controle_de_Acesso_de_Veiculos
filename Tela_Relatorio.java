package projetoControleDeAcessoDeVeiculos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Tela_Relatorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Relatorio frame = new Tela_Relatorio();
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
	public Tela_Relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelatorios = new JLabel("Relatórios:");
		lblRelatorios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRelatorios.setBounds(10, 11, 82, 14);
		contentPane.add(lblRelatorios);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 34, 434, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 127);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Modelo", "Placa", "Valor"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(335, 193, 89, 23);
		panel.add(btnVoltar);
		
		JLabel lblLucros = new JLabel("Lucros:");
		lblLucros.setBounds(10, 148, 44, 12);
		panel.add(lblLucros);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 170, 67, 21);
		panel.add(textArea);
		
		calcularLucros();
		
	}
	
	public void carregarDados (DefaultTableModel modeloOrigem) {
		
		DefaultTableModel modeloDestino = (DefaultTableModel) table.getModel();
		
		modeloDestino.setRowCount(0);
		
		for(int i = 0; i < modeloOrigem.getRowCount(); i++ ) {
			
			modeloDestino.addRow( new Object[] {
				modeloOrigem.getValueAt(i, 0),
				modeloOrigem.getValueAt(i, 3),
				modeloOrigem.getValueAt(i, 4),
				modeloOrigem.getValueAt(i, 9),
			});
			
		}
		
	}
	
	public void calcularLucros() {
		
		double total = 0;
		
		for (Double v : BancoDados.listarValores) {
			
			total += v;
			
		}
		
		textArea.setText(String.format("R$ %.2f", total));
		
	}
}
