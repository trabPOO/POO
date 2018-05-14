package br.ifsp.veterinaria.controle;

import java.util.ArrayList;

import br.ifsp.veterinaria.bd.ClienteDao;
import br.ifsp.veterinaria.bd.JDBCClienteDao;
import br.ifsp.veterinaria.modelo.Cliente;

public class ControleCliente {
	public void gravaCliente(Cliente cliente) {
		ClienteDao cli = new JDBCClienteDao();
		cli.gravaCliente(cliente);
	}
	public ArrayList<Cliente> obterClientes() {
		ClienteDao cli = new JDBCClienteDao();
		return cli.obterClientes();
	}
	public Cliente obterCliente(int idCliente) {
		ClienteDao cli = new JDBCClienteDao();
		return cli.obterCliente(idCliente);
	}
}
