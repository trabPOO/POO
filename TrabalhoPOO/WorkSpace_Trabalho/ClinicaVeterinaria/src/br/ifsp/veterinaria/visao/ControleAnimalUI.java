package br.ifsp.veterinaria.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifsp.veterinaria.visao.ControleAnimalUI;

public class ControleAnimalUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdade;
	private JTextField txtRaca;
	private JLabel lblPorte;
	private JTextField txtPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleAnimalUI frame = new ControleAnimalUI();
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
	public ControleAnimalUI() {
		setTitle("Controle de Animais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(32, 11, 46, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(32, 36, 86, 28);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ra\u00E7a");
		lblNewLabel.setBounds(160, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(160, 36, 150, 28);
		contentPane.add(txtRaca);
		txtRaca.setColumns(10);
		
		lblPorte = new JLabel("Porte");
		lblPorte.setBounds(37, 81, 46, 14);
		contentPane.add(lblPorte);
		
		JRadioButton rdbtnPequeno = new JRadioButton("Pequeno");
		rdbtnPequeno.setBounds(37, 102, 109, 23);
		contentPane.add(rdbtnPequeno);
		
		JRadioButton rdbtnMedio = new JRadioButton("M\u00E9dio");
		rdbtnMedio.setBounds(37, 128, 109, 23);
		contentPane.add(rdbtnMedio);
		
		JRadioButton rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setBounds(37, 154, 109, 23);
		contentPane.add(rdbtnGrande);
		
		JComboBox cbxEspecie = new JComboBox();
		cbxEspecie.setBounds(160, 103, 150, 28);
		contentPane.add(cbxEspecie);
		
		JLabel lblEspcie = new JLabel("Esp\u00E9cie");
		lblEspcie.setBounds(160, 81, 46, 14);
		contentPane.add(lblEspcie);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(37, 436, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(162, 436, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(289, 436, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(418, 436, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(552, 436, 89, 23);
		contentPane.add(btnSair);
		
		JList list = new JList();
		list.setBounds(37, 194, 604, 227);
		contentPane.add(list);
		
		JLabel lblPesquisar = new JLabel("PESQUISAR:");
		lblPesquisar.setBounds(160, 142, 67, 14);
		contentPane.add(lblPesquisar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(160, 156, 481, 29);
		contentPane.add(txtPesquisar);
	}
}
