package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Exemplar;
import br.com.arcs.springstudies.jpa.model.ExemplarId;

public interface ExemplarRepository extends JpaRepository<Exemplar, ExemplarId> {

}
