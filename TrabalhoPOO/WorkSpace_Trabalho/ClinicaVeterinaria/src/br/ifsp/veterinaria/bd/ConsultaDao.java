package br.ifsp.veterinaria.bd;

import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Consulta;

public interface ConsultaDao {
	public void gravaConsulta (Consulta consulta);
	public ArrayList<Consulta> obterConsultas();
	public Consulta obterConsulta(int idConsulta);
}
