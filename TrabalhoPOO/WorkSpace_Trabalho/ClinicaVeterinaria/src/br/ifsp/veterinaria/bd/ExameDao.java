package br.ifsp.veterinaria.bd;

import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Exame;

public interface ExameDao {
	public void gravaExame (Exame exame);
	public ArrayList<Exame> obterExames();
	public Exame obterExame(int idExame);
}
