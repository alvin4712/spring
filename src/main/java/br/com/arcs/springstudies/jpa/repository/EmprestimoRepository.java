package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arcs.springstudies.jpa.model.Emprestimo;
import br.com.arcs.springstudies.jpa.model.EmprestimoId;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, EmprestimoId> {

}
