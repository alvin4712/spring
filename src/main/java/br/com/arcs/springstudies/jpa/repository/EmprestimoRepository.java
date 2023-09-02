package br.com.arcs.springstudies.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcs.springstudies.jpa.model.Emprestimo;
import br.com.arcs.springstudies.jpa.model.EmprestimoId;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, EmprestimoId> {

}
