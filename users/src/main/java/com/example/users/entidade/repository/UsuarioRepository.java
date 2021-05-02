package com.example.users.entidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.entidade.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByNome(String nome);

}
