package br.ifsp.veterinaria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Animal;
import br.ifsp.veterinaria.modelo.Consulta;
import br.ifsp.veterinaria.modelo.Exame;


public class JDBCAnimalDao implements AnimalDao {

	@Override
	public void gravaAnimal(Animal animal) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao ...");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = " INSERT INTO animal (nome, idade, raca, porte, especie, dono_id)" + "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, animal.getNome());
			comando.setInt(2, animal.getIdade());
			comando.setString(3, animal.getRaca());
			comando.setString(4, animal.getPorte());
			comando.setString(5, animal.getEspecie());
			comando.setInt(6, animal.getDono().getId());
			
			System.out.println("Exectando comando...");
			comando.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Animal> obterAnimais() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Animal> listaAnimais = new ArrayList<Animal>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM animal;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			ClienteDao cd = new JDBCClienteDao();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %d %s %s %s\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getInt("idade"),
						resultado.getString("raca"),
						resultado.getString("porte"),
						resultado.getString("especie"),
						resultado.getInt("dono_id"));
				
				Animal a = new Animal();
				a.setId(resultado.getInt("id"));
				a.setNome(resultado.getString("nome"));
				a.setIdade(resultado.getInt("idade"));
				a.setRaca(resultado.getString("raca"));
				a.setPorte(resultado.getString("porte"));
				a.setEspecie(resultado.getString("especie"));
				a.setDono(cd.obterCliente(resultado.getInt("dono_id")));
				
				listaAnimais.add(a);
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return listaAnimais;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Animal obterAnimal(int idAnimal) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM animal where id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, idAnimal);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultado encontrado: \n");
			
			Animal a = new Animal();
			ClienteDao cd = new JDBCClienteDao();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %d %s %s %s\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getInt("idade"),
						resultado.getString("raca"),
						resultado.getString("porte"),
						resultado.getString("especie"),
						resultado.getInt("dono_id"));
				
				a.setId(resultado.getInt("id"));
				a.setNome(resultado.getString("nome"));
				a.setIdade(resultado.getInt("idade"));
				a.setRaca(resultado.getString("raca"));
				a.setPorte(resultado.getString("porte"));
				a.setEspecie(resultado.getString("especie"));
				a.setDono(cd.obterCliente(resultado.getInt("dono_id")));
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return a;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Exame> historicoExames(Animal a) {
		try {
			ArrayList<Exame> listaExames = new ArrayList<Exame>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM exame WHERE animal_id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, a.getId());
			
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %s %s %s %s %s %d\n",
						resultado.getInt("id"),
						resultado.getString("data"),
						resultado.getString("tipoExame"),
						resultado.getString("horario"),
						resultado.getString("local"),
						resultado.getString("resultado"),
						resultado.getString("status"),
						resultado.getInt("animal_id"));
				
				Exame ex = new Exame();
				ex.setId(resultado.getInt("id"));
				ex.setData(resultado.getString("data"));
				ex.setTipoExame(resultado.getString("tipoExame"));
				ex.setHorario(resultado.getString("horario"));
				ex.setLocal(resultado.getString("local"));
				ex.setResultado(resultado.getString("resultado"));
				ex.setStatus(resultado.getString("status"));
				ex.setAnimal(a);
				
				listaExames.add(ex);
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return listaExames;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Consulta> historicoConsultas(Animal a) {
		try {
			ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM consulta WHERE animal_id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, a.getId());
			
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %.2f %s %s %s %s %d\n",
						resultado.getInt("id"),
						resultado.getString("data"),
						resultado.getDouble("valor"),
						resultado.getString("local"),
						resultado.getString("hora"),
						resultado.getString("sintoma"),
						resultado.getString("diagnostico"),
						resultado.getString("status"),
						resultado.getInt("animal_id"));
				
				Consulta con = new Consulta();
				con.setId(resultado.getInt("id"));
				con.setData(resultado.getString("data"));
				con.setValor(resultado.getDouble("valor"));
				con.setHora(resultado.getString("hora"));
				con.setLocal(resultado.getString("local"));
				con.setSintoma(resultado.getString("sintoma"));
				con.setDiagnostico(resultado.getString("diagnostico"));
				con.setStatus(resultado.getString("status"));
				con.setAnimal(a);
				
				listaConsultas.add(con);
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return listaConsultas;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
