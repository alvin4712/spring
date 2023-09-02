package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
