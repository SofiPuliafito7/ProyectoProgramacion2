package com.cooweb.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooweb.model.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import com.cooweb.dao.UsuarioDao;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value="Hola")
	public String mensaje() {
		return "Hola";
	}
	
	@RequestMapping(value="personas")
	public List<String> listaPersonas() {
		return List.of("Sofia", "Victoria", "Luciano");
	}
	
	@RequestMapping(value="usuarios")
	public Usuario listarUsuarios() {
		Usuario user = new Usuario();
		user.setNombre("Sofia");
		user.setApellido("Puliafito");
		user.setEmail("sofia@gmail.com");
		user.setTelefono("261678900");
		user.setPassword("contrasenia123");
		return user;
	}
	
	@RequestMapping(value="usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario user = new Usuario();
		user.setId(id);
		user.setNombre("Sofia");
		user.setApellido("Puliafito");
		user.setEmail("sofia@gmail.com");
		user.setTelefono("261678900");
		user.setPassword("contrasenia123");
		return user;
	}
	
	@RequestMapping(value="listar/usuarios")
	public List<Usuario> listarVariosUsuarios() {
		List<Usuario> user = new ArrayList<>();
		
		Usuario user1 = new Usuario();
		user1.setId(0L);
		user.setNombre("Sofia");
		user.setApellido("Puliafito");
		user.setEmail("sofia@gmail.com");
		user.setTelefono("261678900");
		user.setPassword("contrasenia123");
		
		Usuario user2 = new Usuario();
		user2.setId(1L);
		user2.setNombre("Victoria");
		user2.setApellido("Gomez");
		user2.setEmail("victoria@gmail.com");
		user2.setTelefono("261534344");
		user2.setPassword("ContrasEnia123");
		
		Usuario user3 = new Usuario();
		user3.setId(2L);
		user3.setNombre("Luciano");
		user3.setApellido("Lopez");
		user3.setEmail("luciano@gmail.com");
		user3.setTelefono("261778800");
		user3.setPassword("cONTRASENIA123");
		
		user.add(user1);
		user.add(user2);
		user.add(user3);
		
		return user;
	}
	
	@RequestMapping(value="api/usuarios")
	public List<Usuario> getUsuario() {
		List<Usuario> user = usuarioDao.getUsuarios();
		return user;
	}
	
	@RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable Long id) {
		usuarioDao.eliminarUsuario(id);
	}
	
	@RequestMapping(value="api/usuarios", method = RequestMethod.POST)
	public void registrarUsuario(@RequestBody Usuario user) {
		Argon2 argon2;
		argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);
		String pass_hasheado = argon2.hash(1, 1024, 1, user.getPassword());
		user.setPassword(pass_hasheado);
		usuarioDao.registrarUsuario(user);
	}
}
