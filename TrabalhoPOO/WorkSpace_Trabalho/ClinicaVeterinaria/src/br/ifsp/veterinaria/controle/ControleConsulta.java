package br.ifsp.veterinaria.controle;

import java.util.ArrayList;

import br.ifsp.veterinaria.bd.ConsultaDao;
import br.ifsp.veterinaria.bd.JDBCConsultaDao;
import br.ifsp.veterinaria.modelo.Consulta;

public class ControleConsulta {
	public void gravaConsulta(Consulta consulta) {
		ConsultaDao cd = new JDBCConsultaDao();
		cd.gravaConsulta(consulta);
	}
	public ArrayList<Consulta> obterConsultas(Consulta consulta) {
		ConsultaDao cd = new JDBCConsultaDao();
		return cd.obterConsultas();
		
	}
	public Consulta obterConsulta(int idConsulta) {
		ConsultaDao cd = new JDBCConsultaDao();
		return cd.obterConsulta(idConsulta);
	}
}
