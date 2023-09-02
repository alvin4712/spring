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
@EqualsAndHashCode(of = "codigo")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Editora {
    @Id
    private Long codigo;
    private String nome;
    private String cidade;
}
