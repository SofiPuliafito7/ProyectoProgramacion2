package com.cooweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cooweb.model.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class UsuarioDaoImp implements UsuarioDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Usuario> getUsuarios() {
		String query = "FROM Usuario";
		List<Usuario> resultado = entityManager.createQuery(query).getResultList();
		
		return resultado;
	}

	@Override
	public void eliminarUsuario(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
				
	}

	@Override
	public void registrarUsuario(Usuario user) {
		entityManager.merge(user);
		
	}

	@Override
	public boolean verificarCredenciales(Usuario user) {
		String query = "FROM Usuario WHERE email = :email";
		List<Usuario> lista = entityManager.createQuery(query).setParameter("email", user.getEmail()).getResultList();
		
		if (lista.isEmpty()) {
			return false;
		}
		
		String passHasheada = lista.get(0).getPassword();
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
		boolean passEsCorrecta = argon2.verify(getPassword, user.getPassword());
		
		return passwordEsCorrecta;
	}

}
