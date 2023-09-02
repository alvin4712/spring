package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AutoriaId {
    @Max(45)
    private String livroIsbn;
    private Long autorCodigo;
}
