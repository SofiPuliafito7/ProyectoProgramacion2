package com.cooweb.controller;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooweb.model.Cliente;
import com.cooweb.dao.ClienteDao;

@RestController
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao;

	
	@RequestMapping(value="clientes/{id}")
	public Cliente getCliente(@PathVariable Long id) {
		Cliente client = new Cliente();
		client.setId(id);
		client.setNombre("Maria");
		client.setApellido("Paez");
		client.setEmail("maria@gmail.com");
		client.setTelefono("261675444");
		client.setDireccion("Calle 1, Guaymallén");
		client.setCumpleaños(LocalDate.of(2000, 03, 10));
		return client;
	}
	
	@RequestMapping(value="listar/clientes")
	public List<Cliente> listarVariosClientes() {
		List<Cliente> client = new ArrayList<>();
		
		Cliente client1 = new Cliente();
		client1.setId(0L);
		client1.setNombre("Maria");
		client1.setApellido("Paez");
		client1.setEmail("maria@gmail.com");
		client1.setTelefono("261675444");
		client1.setDireccion("Calle 1, Guaymallén");
		client1.setCumpleaños(LocalDate.of(2000, 03, 10));
		
		Cliente client2 = new Cliente();
		client2.setId(1L);
		client2.setNombre("Graciela");
		client2.setApellido("Sosa");
		client2.setEmail("graciela@gmail.com");
		client2.setTelefono("261905444");
		client2.setDireccion("Calle 2, Maipu");
		client2.setCumpleaños(LocalDate.of(1998, 08, 25));
		
		Cliente client3 = new Cliente();
		client3.setId(2L);
		client3.setNombre("Paulo");
		client3.setApellido("Dybala");
		client3.setEmail("paulo@gmail.com");
		client3.setTelefono("261609844");
		client3.setDireccion("Calle 3, Godoy Cruz");
		client3.setCumpleaños(LocalDate.of(1951, 10, 05));
		
		client.add(client1);
		client.add(client2);
		client.add(client3);
		
		return client;
	}
	
	@RequestMapping(value="api/clientes")
	public List<Cliente> getCliente() {
		List<Cliente> client = clienteDao.obtenerClientes();
		return client;
	}
}
