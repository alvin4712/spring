package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = "isbn")
@ToString
@Entity
public class Livro {
    @Id
    private String isbn;
    private String titulo;
    private Integer edicao;
    private Integer volume;
    @ManyToOne
    private Genero genero;
    @ManyToOne
    private Editora editora;
}
