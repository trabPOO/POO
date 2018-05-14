package br.ifsp.veterinaria.controle;

import java.util.ArrayList;

import br.ifsp.veterinaria.bd.JDBCVeterinarioDao;
import br.ifsp.veterinaria.bd.VeterinarioDao;
import br.ifsp.veterinaria.modelo.Veterinario;

public class ControleVeterinario {
	public void gravaVeterinario(Veterinario veterinario) {
		VeterinarioDao vet = new JDBCVeterinarioDao();
		vet.gravaVeterinario(veterinario);
	}
	public ArrayList<Veterinario> obterVeterinarios() {
		VeterinarioDao vet = new JDBCVeterinarioDao();
		return vet.obterVeterinarios();
	}
	public Veterinario obterVeterinario(int idVeterinario) {
		VeterinarioDao vet = new JDBCVeterinarioDao();
		return vet.obterVeterinario(idVeterinario);
	}
}
