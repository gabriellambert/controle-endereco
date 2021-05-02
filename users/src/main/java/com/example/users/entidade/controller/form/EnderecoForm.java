package com.example.users.entidade.controller.form;

import javax.persistence.ManyToOne;

import com.example.users.entidade.Endereco;
import com.example.users.entidade.Usuario;
import com.example.users.entidade.repository.UsuarioRepository;

public class EnderecoForm {
	
	@NotNull @NotEmpty
	private String logradouro;
	@NotNull @NotEmpty
	private String numero;
	@NotNull @NotEmpty
	private String complemento;
	@NotNull @NotEmpty
	private String bairro;
	@NotNull @NotEmpty
	private String cidade;
	@NotNull @NotEmpty
	private String estado;
	@NotNull @NotEmpty
	private String cep;
	@ManyToOne
	private String nomeUsuario;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUsuario() {
		return nomeUsuario;
	}
	public void setUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Endereco converter(UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
		return new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, usuario);
	}
	
}
