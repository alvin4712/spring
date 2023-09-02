package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, String>{
    
}
