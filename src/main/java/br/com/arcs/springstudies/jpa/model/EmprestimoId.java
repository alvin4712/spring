package br.com.arcs.springstudies.jpa.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class EmprestimoId {
    @Max(11)
    private String usuarioId;
    private ExemplarId exemplarId;
    private LocalDateTime dataEmprestimo;
}
