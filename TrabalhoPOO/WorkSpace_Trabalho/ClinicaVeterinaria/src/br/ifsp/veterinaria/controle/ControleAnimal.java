package br.ifsp.veterinaria.controle;

import java.util.ArrayList;

import br.ifsp.veterinaria.bd.AnimalDao;
import br.ifsp.veterinaria.bd.JDBCAnimalDao;
import br.ifsp.veterinaria.modelo.Animal;
import br.ifsp.veterinaria.modelo.Consulta;
import br.ifsp.veterinaria.modelo.Exame;

public class ControleAnimal {
	public void gravaAnimal(Animal animal) {
		AnimalDao am = new JDBCAnimalDao();
		am.gravaAnimal(animal);
	}
	public ArrayList<Animal> obterAnimais() {
		AnimalDao am = new JDBCAnimalDao();
		return am.obterAnimais();
	}
	public Animal obterAnimal(int idAnimal) {
		AnimalDao am = new JDBCAnimalDao();
		return am.obterAnimal(idAnimal);
	}
	public ArrayList<Exame> historicoExames(Animal a){
		AnimalDao am = new JDBCAnimalDao();
		return am.historicoExames(a);
	}
	public ArrayList<Consulta> historicoConsultas(Animal a) {
		AnimalDao am = new JDBCAnimalDao();
		return am.historicoConsultas(a);
	}
}
