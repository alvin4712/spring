package br.com.arcs.springstudies.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
    // @Max(11)
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    @ManyToOne
    @NotNull
    private Perfil perfil;
}
