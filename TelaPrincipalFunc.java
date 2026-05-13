package projetoControleDeAcessoDeVeiculos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipalFunc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalFunc frame = new TelaPrincipalFunc();
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
	public TelaPrincipalFunc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem - Vindo!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 189, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 34, 434, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCouE = new JButton("Cadastrar ou Excluir");
		btnCouE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastro tlcadastro = new telaCadastro();
				tlcadastro.setVisible(true);
			}
		});
		btnCouE.setBounds(28, 50, 372, 23);
		panel.add(btnCouE);
		
		JButton btnVerVagas = new JButton("Vagas Disponíveis");
		btnVerVagas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_Vagas tlvagas = new Tela_Vagas();
				tlvagas.setVisible(true);
			}
		});
		btnVerVagas.setBounds(28, 83, 372, 23);
		panel.add(btnVerVagas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(271, 177, 129, 23);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("O que gostaria de realizar?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(145, 10, 148, 12);
		panel.add(lblNewLabel_1);

	}
}
