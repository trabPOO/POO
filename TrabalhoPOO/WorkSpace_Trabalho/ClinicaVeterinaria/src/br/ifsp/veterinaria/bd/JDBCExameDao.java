package br.ifsp.veterinaria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Exame;


public class JDBCExameDao implements ExameDao {

	@Override
	public void gravaExame(Exame exame) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao ...");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = " INSERT INTO exame (data, tipoExame, horario, local, resultado, status, animal_id)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, exame.getData());
			comando.setString(2, exame.getTipoExame());
			comando.setString(3, exame.getHorario());
			comando.setString(4, exame.getLocal());
			comando.setString(5, exame.getResultado());
			comando.setString(6, exame.getStatus());
			comando.setInt(7, exame.getAnimal().getId());
			
			System.out.println("Exectando comando...");
			comando.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Exame> obterExames() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Exame> listaExames = new ArrayList<Exame>();
			AnimalDao a = new JDBCAnimalDao();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM exame;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
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
				ex.setAnimal(a.obterAnimal(resultado.getInt("animal_id")));
				
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
	public Exame obterExame(int idExame) {
		// TODO Auto-generated method stub
		
		try {
			AnimalDao a = new JDBCAnimalDao();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM exame where id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, idExame);
			
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			Exame ex = new Exame();
			
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
				
				ex.setId(resultado.getInt("id"));
				ex.setData(resultado.getString("data"));
				ex.setTipoExame(resultado.getString("tipoExame"));
				ex.setHorario(resultado.getString("horario"));
				ex.setLocal(resultado.getString("local"));
				ex.setResultado(resultado.getString("resultado"));
				ex.setStatus(resultado.getString("status"));
				ex.setAnimal(a.obterAnimal(resultado.getInt("animal_id")));
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return ex;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
