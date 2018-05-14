package br.ifsp.veterinaria.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifsp.veterinaria.visao.ControleClienteUI;

public class ControleClienteUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtPesquisar;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleClienteUI frame = new ControleClienteUI();
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
	public ControleClienteUI() {
		setTitle("Controle de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(36, 439, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(161, 439, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(288, 439, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(417, 439, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(551, 439, 89, 23);
		contentPane.add(btnSair);
		
		txtNome = new JTextField();
		txtNome.setBounds(36, 42, 483, 29);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 21, 46, 14);
		contentPane.add(lblNome);
		
		txtCpf = new JTextField();
		txtCpf.setText("000.000.000-00");
		txtCpf.setBounds(529, 42, 111, 29);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(529, 21, 46, 14);
		contentPane.add(lblCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(36, 103, 242, 29);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(36, 82, 46, 14);
		contentPane.add(lblTelefone);
		
		JList list = new JList();
		list.setBounds(36, 215, 604, 213);
		contentPane.add(list);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(36, 175, 604, 29);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("PESQUISAR:");
		lblPesquisar.setBounds(36, 161, 67, 14);
		contentPane.add(lblPesquisar);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(288, 82, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(288, 103, 352, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
	}

}
