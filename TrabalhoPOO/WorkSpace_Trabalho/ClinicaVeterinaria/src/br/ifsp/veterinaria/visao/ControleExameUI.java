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

import br.ifsp.veterinaria.visao.ControleExameUI;

public class ControleExameUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtLocal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleExameUI frame = new ControleExameUI();
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
	public ControleExameUI() {
		setTitle("Marcar Exame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(552, 429, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBounds(418, 429, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBounds(289, 429, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.setBounds(162, 429, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(37, 429, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(35, 27, 46, 14);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setText("dd/MM/aaaa");
		txtData.setColumns(10);
		txtData.setBounds(35, 43, 68, 29);
		contentPane.add(txtData);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(131, 27, 46, 14);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setText("hh:MM:ss");
		txtHora.setColumns(10);
		txtHora.setBounds(131, 43, 68, 29);
		contentPane.add(txtHora);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(229, 27, 46, 14);
		contentPane.add(lblLocal);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(229, 43, 267, 29);
		contentPane.add(txtLocal);
		
		JLabel lblTipo = new JLabel(" Tipo de Exame");
		lblTipo.setBounds(517, 27, 79, 14);
		contentPane.add(lblTipo);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(37, 83, 66, 14);
		contentPane.add(lblResultado);
		
		JComboBox cbxTipo = new JComboBox();
		cbxTipo.setBounds(517, 43, 124, 29);
		contentPane.add(cbxTipo);
		
		JList list = new JList();
		list.setBounds(37, 108, 604, 307);
		contentPane.add(list);
	}

}
