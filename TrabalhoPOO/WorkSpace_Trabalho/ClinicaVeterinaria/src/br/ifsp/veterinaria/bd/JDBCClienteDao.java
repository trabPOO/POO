package br.ifsp.veterinaria.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Cliente;


public class JDBCClienteDao implements ClienteDao {

	@Override
	public void gravaCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Abrindo conexao ...");
			
			Connection conexao = ConnectionFactory.createConnection();
			
			String sql = " INSERT INTO cliente (nome, cpf, telefone, email)" + "VALUES (?, ?, ?, ?)";
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setString(1, cliente.getNome());
			comando.setString(2, cliente.getCpf());
			comando.setDouble(3, cliente.getTelefone());
			comando.setString(4, cliente.getEmail());
			
			System.out.println("Exectando comando...");
			comando.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Cliente> obterClientes() {
		// TODO Auto-generated method stub
		try {
			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM cliente;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			while(resultado.next()) {
				System.out.printf("%d - %s %s %f %s\\n\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getString("cpf"),
						resultado.getDouble("telefone"),
						resultado.getString("email"));
					
				Cliente c = new Cliente();
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setCpf(resultado.getString("cpf"));
				c.setTelefone(resultado.getDouble("telefone"));
				c.setEmail(resultado.getString("email"));			
				
				listaClientes.add(c);
				
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return listaClientes;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Cliente obterCliente(int idCliente) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Abrindo conexao");
			Connection conexao = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM cliente where id = ?;";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			
			comando.setInt(1, idCliente);
			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();
			
			System.out.println("Resultado encontrado: \n");
			
			Cliente c = new Cliente();
			
			while(resultado.next()) {
				System.out.printf("%d - %s %s %f %s\n",
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getString("cpf"),
						resultado.getDouble("telefone"),
						resultado.getString("email"));
				
				c.setId(resultado.getInt("id"));
				c.setNome(resultado.getString("nome"));
				c.setCpf(resultado.getString("cpf"));
				c.setTelefone(resultado.getDouble("telefone"));
				c.setEmail(resultado.getString("email"));
			}
			
			System.out.println("\n Fechando conexao");
			
			conexao.close();
			return c;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
