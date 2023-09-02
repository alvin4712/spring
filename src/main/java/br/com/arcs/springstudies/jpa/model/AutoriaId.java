package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AutoriaId {
    private Long livroIsbn;
    private Long autorCodigo;
}
