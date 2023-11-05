package com.cooweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooweb.dao.UsuarioDao;
import com.cooweb.model.Usuario;

@RestController
public class AuthController {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping(value="api/login", method = RequestMethod.POST)
	public String login(@RequestBody Usuario user) {
		if(usuarioDao.verificarCredenciales(user)) {
			return "OK";
		}
		return "FAIL";
	}
}
