package com.cooweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cooweb.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteDaoImp implements ClienteDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cliente> obtenerClientes() {
		String query = "FROM Cliente";
		List<Cliente> resultado = entityManager.createQuery(query).getResultList();
		
		return resultado;
	}

}
