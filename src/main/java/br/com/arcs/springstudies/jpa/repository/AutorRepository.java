package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
