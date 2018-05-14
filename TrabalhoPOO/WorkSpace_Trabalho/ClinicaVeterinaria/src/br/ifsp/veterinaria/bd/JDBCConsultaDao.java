package br.ifsp.veterinaria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Consulta;


public class JDBCConsultaDao implements ConsultaDao {

	@Override
	public void gravaConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao ...");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = " INSERT INTO consulta (data, valor, local, hora, sintoma, diagnostico, status, animal_id)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, consulta.getData());
			comando.setDouble(2, consulta.getValor());
			comando.setString(3, consulta.getLocal());
			comando.setString(4, consulta.getHora());
			comando.setString(5, consulta.getSintoma());
			comando.setString(6, consulta.getDiagnostico());
			comando.setString(7, consulta.getStatus());
			comando.setInt(8, consulta.getAnimal().getId());
			
			System.out.println("Exectando comando...");
			comando.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Consulta> obterConsultas() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM consulta;";
			AnimalDao a = new JDBCAnimalDao();
			PreparedStatement comando = conexao.prepareStatement(sql);
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
				con.setAnimal(a.obterAnimal(resultado.getInt("animal_id")));
				
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

	@Override
	public Consulta obterConsulta(int idConsulta) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM consulta where id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, idConsulta);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultado encontrado: \n");
			AnimalDao a = new JDBCAnimalDao();
			Consulta con = new Consulta();
			
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
				
				con.setId(resultado.getInt("id"));
				con.setData(resultado.getString("data"));
				con.setValor(resultado.getDouble("valor"));
				con.setHora(resultado.getString("hora"));
				con.setLocal(resultado.getString("local"));
				con.setSintoma(resultado.getString("sintoma"));
				con.setDiagnostico(resultado.getString("diagnostico"));
				con.setStatus(resultado.getString("status"));
				con.setAnimal(a.obterAnimal(resultado.getInt("animal_id")));

				
			}
			System.out.println("\n Fechando conexao");		
			conexao.close();
			
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
