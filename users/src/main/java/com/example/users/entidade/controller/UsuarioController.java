package com.example.users.entidade.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.entidade.Usuario;
import com.example.users.entidade.repository.UsuarioRepository;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

	private UsuarioRepository repository;
	
	UsuarioController(UsuarioRepository usuarioRepository) {
		this.repository = usuarioRepository;
	}
	
	@GetMapping
	public List findAll(){
	   return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario){
	   return repository.save(usuario);
	}
}


