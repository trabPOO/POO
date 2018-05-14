package br.ifsp.veterinaria.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.ifsp.veterinaria.visao.ControleVeterinarioUI;

public class ControleVeterinarioUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCrm;
	private JTextField txtEspecializacao;
	private JTextField txtCpf;
	private JTextField txtSalario;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleVeterinarioUI frame = new ControleVeterinarioUI();
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
	public ControleVeterinarioUI() {
		setTitle("Controle de Veterin\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(39, 433, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(164, 433, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(291, 433, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(420, 433, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(554, 433, 89, 23);
		contentPane.add(btnSair);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(39, 42, 483, 29);
		contentPane.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(39, 21, 46, 14);
		contentPane.add(lblNome);
		
		txtCrm = new JTextField();
		txtCrm.setHorizontalAlignment(SwingConstants.LEFT);
		txtCrm.setColumns(10);
		txtCrm.setBounds(532, 42, 111, 29);
		contentPane.add(txtCrm);
		
		JLabel lblCrm = new JLabel("CRM");
		lblCrm.setBounds(532, 21, 46, 14);
		contentPane.add(lblCrm);
		
		txtEspecializacao = new JTextField();
		txtEspecializacao.setColumns(10);
		txtEspecializacao.setBounds(39, 103, 362, 29);
		contentPane.add(txtEspecializacao);
		
		JLabel lblEspecializacao = new JLabel("Especializa\u00E7\u00E3o");
		lblEspecializacao.setBounds(39, 82, 76, 14);
		contentPane.add(lblEspecializacao);
		
		txtCpf = new JTextField();
		txtCpf.setText("000.000.000-00");
		txtCpf.setColumns(10);
		txtCpf.setBounds(411, 103, 111, 29);
		contentPane.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(411, 82, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSalario = new JLabel("Sal\u00E1rio");
		lblSalario.setBounds(532, 82, 46, 14);
		contentPane.add(lblSalario);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(532, 103, 111, 29);
		contentPane.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(39, 143, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(39, 163, 362, 29);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(411, 143, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(411, 163, 232, 29);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JList list = new JList();
		list.setBounds(39, 203, 604, 219);
		contentPane.add(list);
	}

}
