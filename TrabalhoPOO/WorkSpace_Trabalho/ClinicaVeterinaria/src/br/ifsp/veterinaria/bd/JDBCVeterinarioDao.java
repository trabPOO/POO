package br.ifsp.veterinaria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Veterinario;


public class JDBCVeterinarioDao implements VeterinarioDao {

	@Override
	public void gravaVeterinario(Veterinario veterinario) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao ...");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = " INSERT INTO cliente (nome, crm, especializacao, cpf, salario)" + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, veterinario.getNome());
			comando.setString(2, veterinario.getCrm());
			comando.setString(3, veterinario.getEspecializacao());
			comando.setString(4, veterinario.getCpf());
			comando.setDouble(5, veterinario.getSalario());
			
			System.out.println("Exectando comando...");
			comando.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Veterinario> obterVeterinarios() {
		try {
			ArrayList<Veterinario> listaVeterinarios = new ArrayList<Veterinario>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM veterinario;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			while(resultado.next()) {
				System.out.printf("%d - %s %s %s %s %.2f\n\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getString("crm"),
						resultado.getString("especializacao"),
						resultado.getString("cpf"),
						resultado.getDouble("salario"));
					
				Veterinario vet = new Veterinario();
				vet.setId(resultado.getInt("id"));
				vet.setNome(resultado.getString("nome"));
				vet.setCrm(resultado.getString("crm"));
				vet.setEspecializacao(resultado.getString("especializacao"));
				vet.setCpf(resultado.getString("cpf"));	
				vet.setSalario(resultado.getDouble("salario"));
				
				listaVeterinarios.add(vet);
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return listaVeterinarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Veterinario obterVeterinario(int idVeterinario) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM veterinario where id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, idVeterinario);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultado encontrado: \n");
			
			Veterinario vet = new Veterinario();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %s %s %s %.2f\n\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getString("crm"),
						resultado.getString("especializacao"),
						resultado.getString("cpf"),
						resultado.getDouble("salario"));
				
				vet.setId(resultado.getInt("id"));
				vet.setNome(resultado.getString("nome"));
				vet.setCrm(resultado.getString("crm"));
				vet.setEspecializacao(resultado.getString("especializacao"));
				vet.setCpf(resultado.getString("cpf"));	
				vet.setSalario(resultado.getDouble("salario"));
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return vet;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
