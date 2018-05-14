package br.ifsp.veterinaria.bd;

import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Veterinario;

public interface VeterinarioDao {
	public void gravaVeterinario (Veterinario veterinario);
	public ArrayList<Veterinario> obterVeterinarios();
	public Veterinario obterVeterinario(int idVeterinario);
}
