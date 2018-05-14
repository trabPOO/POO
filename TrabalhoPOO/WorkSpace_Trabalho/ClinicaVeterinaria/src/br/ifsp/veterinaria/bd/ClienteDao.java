package br.ifsp.veterinaria.bd;

import java.util.ArrayList;

import br.ifsp.veterinaria.modelo.Cliente;

public interface ClienteDao {
	public void gravaCliente (Cliente cliente);
	public ArrayList<Cliente> obterClientes();
	public Cliente obterCliente(int idCliente);
}
