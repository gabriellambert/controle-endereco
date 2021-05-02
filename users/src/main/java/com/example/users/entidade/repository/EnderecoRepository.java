package com.example.users.entidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.entidade.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	List<Endereco> findByUsuarioNome(String nomeUsuario);

}
