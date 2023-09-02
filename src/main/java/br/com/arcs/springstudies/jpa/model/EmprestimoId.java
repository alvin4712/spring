package br.com.arcs.springstudies.jpa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class EmprestimoId {
    private String usuarioId;
    private ExemplarId exemplarId;
    private LocalDateTime dataEmprestimo;
}
