package br.ifsp.veterinaria.controle;

import java.util.ArrayList;

import br.ifsp.veterinaria.bd.ExameDao;
import br.ifsp.veterinaria.bd.JDBCExameDao;
import br.ifsp.veterinaria.modelo.Exame;

public class ControleExame {
	public void gravaExame(Exame exame) {
		ExameDao ex = new JDBCExameDao();
		ex.gravaExame(exame);
	}
	public ArrayList<Exame> obterExames() {
		ExameDao ex = new JDBCExameDao();
		return ex.obterExames();
	}
	public Exame obterExame(int idExame) {
		ExameDao ex = new JDBCExameDao();
		return ex.obterExame(idExame);
	}
	
}
