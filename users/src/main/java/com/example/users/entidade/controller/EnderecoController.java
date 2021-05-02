package com.example.users.entidade.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.users.entidade.Endereco;
import com.example.users.entidade.controller.dto.EnderecoDto;
import com.example.users.entidade.controller.form.EnderecoForm;
import com.example.users.entidade.repository.EnderecoRepository;
import com.example.users.entidade.repository.UsuarioRepository;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	private EnderecoRepository repository;
	
	EnderecoController(EnderecoRepository enderecoRepository) {
		this.repository = enderecoRepository;
	}
	
	@GetMapping
	public List<EnderecoDto> lista(String nomeUsuario) {
		if (nomeUsuario == null) {
			List<Endereco> enderecos = repository.findAll();
			return EnderecoDto.converter(enderecos);
		} else {
			List<Endereco> enderecos = repository.findByUsuarioNome(nomeUsuario);
			return EnderecoDto.converter(enderecos);
		}
	}
	
	@GetMapping("/{id}")
	public EnderecoDto detalhar(@PathVariable Long id) {
		Endereco endereco = repository.getOne(id);
		return new EnderecoDto(endereco);
	}
	
	@PostMapping
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder){
		Endereco endereco = form.converter(usuarioRepository);
		repository.save(endereco);
		
		URI uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
	}
}
