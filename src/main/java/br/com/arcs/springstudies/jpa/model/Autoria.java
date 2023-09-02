package br.com.arcs.springstudies.jpa.model;

import java.io.Serializable;

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
public class Autoria implements Serializable{
    @EmbeddedId
    private AutoriaId autoriaId;

    
    @ManyToOne
    @MapsId("autorCodigo")
    private Autor autor;

    @ManyToOne
    @MapsId("livroIsbn")
    private Livro livro;
}
