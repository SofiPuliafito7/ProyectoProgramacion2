package com.cooweb.dao;

import java.util.List;

import com.cooweb.model.Cliente;

import jakarta.transaction.Transactional;

@Transactional
public interface ClienteDao {
	
	List<Cliente> obtenerClientes();
}
