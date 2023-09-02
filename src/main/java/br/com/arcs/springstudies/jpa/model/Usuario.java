package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    @ManyToOne
    private Perfil perfil;
}
