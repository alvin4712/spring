package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Autoria;
import br.com.arcs.springstudies.jpa.model.AutoriaId;

public interface AutoriaRepository extends JpaRepository<Autoria, AutoriaId>{
    
}
