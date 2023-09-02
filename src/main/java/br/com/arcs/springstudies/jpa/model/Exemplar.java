package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Exemplar {
    @EmbeddedId
    private ExemplarId exemplarId;

    @MapsId("livroIsbn")
    @ManyToOne
    private Livro livro;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public static enum Status {
        EMPRESTADO, MANUTENCAO, ESTOQUE;
    }

}
