package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arcs.springstudies.jpa.model.Autoria;
import br.com.arcs.springstudies.jpa.model.AutoriaId;

@Repository
public interface AutoriaRepository extends JpaRepository<Autoria, AutoriaId> {

}
