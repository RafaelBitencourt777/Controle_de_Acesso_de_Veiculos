package projetoControleDeAcessoDeVeiculos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLogin;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("OptionPane.border"));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.BLACK);
		panel.setBounds(104, 23, 231, 194);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLogin.setBounds(30, 24, 36, 14);
		panel.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(30, 65, 41, 14);
		panel.add(lblSenha);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(72, 23, 95, 20);
		panel.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(72, 62, 95, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldLogin.getText().equals("Admin") && textFieldSenha.getText().equals("Adm123")) {
					JOptionPane.showMessageDialog(null, "Usuário Logado");
					TelaPrincipalADM tlADM = new TelaPrincipalADM();
					tlADM.setVisible(true);
				} else if (textFieldLogin.getText().equals("Func") && textFieldSenha.getText().equals("Fcn123")) {
					JOptionPane.showMessageDialog(null, "Usuário Logado");
					TelaPrincipalFunc tlfunc = new TelaPrincipalFunc();
					tlfunc.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário Não Logado");
				}
			}
		});
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setBackground(new Color(100, 149, 237));
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirmar.setBounds(66, 127, 89, 23);
		panel.add(btnConfirmar);
		

	
	}
}

