package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@EqualsAndHashCode(of = "codigo")
@ToString
@Entity
public class Perfil {
    @Id
    private Long codigo;
    private String nome;
    private Integer limite;
    private Integer prazo;
}
