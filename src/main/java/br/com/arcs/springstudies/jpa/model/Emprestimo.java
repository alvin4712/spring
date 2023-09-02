package br.com.arcs.springstudies.jpa.model;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Emprestimo {
    @EmbeddedId
    private EmprestimoId emprestimoId;

    @MapsId("usuarioId")
    @ManyToOne
    private Usuario usuario;

    @MapsId("exemplarId")
    @ManyToOne
    private Exemplar exemplar;

    private LocalDateTime dataEntega;
    private Integer prazo;
}
