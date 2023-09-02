package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Perfil {
    @Id
    private Long codigo;
    private String nome;
    private Integer limite;
    private Integer prazo;
}
