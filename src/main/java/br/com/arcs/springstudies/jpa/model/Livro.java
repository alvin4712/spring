package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "isbn")
@ToString
@Entity
public class Livro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer edicao;
    private Integer volume;
    @ManyToOne
    private Genero genero;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Editora editora;
}
