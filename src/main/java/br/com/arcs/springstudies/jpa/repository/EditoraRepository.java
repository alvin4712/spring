package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arcs.springstudies.jpa.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}
