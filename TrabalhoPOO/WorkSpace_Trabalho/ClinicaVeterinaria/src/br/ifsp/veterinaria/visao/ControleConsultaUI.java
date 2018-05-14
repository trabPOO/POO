package br.ifsp.veterinaria.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifsp.veterinaria.visao.ControleConsultaUI;

public class ControleConsultaUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtLocal;
	private JLabel lblVeterinrio;
	private JComboBox cbxVeterinario;
	private JLabel lblAnimal;
	private JComboBox cbxAnimal;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JButton btnSair;
	private JList list;
	private JTextField txtPesquisar;
	private JLabel lblPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleConsultaUI frame = new ControleConsultaUI();
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
	public ControleConsultaUI() {
		setTitle("Controle de Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(35, 25, 46, 14);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setText("dd/MM/aaaa");
		txtData.setColumns(10);
		txtData.setBounds(35, 41, 68, 29);
		contentPane.add(txtData);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(139, 25, 46, 14);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setText("hh:MM:ss");
		txtHora.setColumns(10);
		txtHora.setBounds(139, 41, 68, 29);
		contentPane.add(txtHora);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(240, 25, 46, 14);
		contentPane.add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(240, 41, 267, 29);
		contentPane.add(txtLocal);
		
		lblVeterinrio = new JLabel("Veterin\u00E1rio");
		lblVeterinrio.setBounds(34, 81, 68, 14);
		contentPane.add(lblVeterinrio);
		
		cbxVeterinario = new JComboBox();
		cbxVeterinario.setBounds(34, 100, 132, 29);
		contentPane.add(cbxVeterinario);
		
		lblAnimal = new JLabel("Animal");
		lblAnimal.setBounds(214, 81, 68, 14);
		contentPane.add(lblAnimal);
		
		cbxAnimal = new JComboBox();
		cbxAnimal.setBounds(214, 100, 132, 29);
		contentPane.add(cbxAnimal);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(37, 431, 89, 23);
		contentPane.add(btnSalvar);
		
		btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(162, 431, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(289, 431, 89, 23);
		contentPane.add(btnExcluir);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(418, 431, 89, 23);
		contentPane.add(btnLimpar);
		
		btnSair = new JButton("SAIR");
		btnSair.setBounds(552, 431, 89, 23);
		contentPane.add(btnSair);
		
		list = new JList();
		list.setBounds(33, 188, 608, 231);
		contentPane.add(list);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(35, 154, 606, 29);
		contentPane.add(txtPesquisar);
		
		lblPesquisar = new JLabel("PESQUISAR:");
		lblPesquisar.setBounds(35, 140, 67, 14);
		contentPane.add(lblPesquisar);
	}

}
