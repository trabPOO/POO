package br.ifsp.veterinaria.bd;

import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Animal;
import br.ifsp.veterinaria.modelo.Consulta;
import br.ifsp.veterinaria.modelo.Exame;

public interface AnimalDao {
	public void gravaAnimal (Animal animal);
	public ArrayList<Animal> obterAnimais();
	public Animal obterAnimal(int idAnimal);
	public ArrayList<Exame> historicoExames(Animal a);
	public ArrayList<Consulta> historicoConsultas(Animal a);
}
