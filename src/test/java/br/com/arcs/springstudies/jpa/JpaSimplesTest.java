package br.com.arcs.springstudies.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.arcs.springstudies.jpa.model.Perfil;
import br.com.arcs.springstudies.jpa.repository.PerfilRepository;

@SpringBootTest
public class JpaSimplesTest {
    @Autowired
    PerfilRepository perfilRepository;

    @Test
    void persistenciaSimplesTest() {
        Perfil cliente = new Perfil(2l, "CLIENTE", 2, 10);
        perfilRepository.save(cliente);
        assertEquals(cliente, perfilRepository.findById(cliente.getCodigo()).get());
        assertEquals(1, perfilRepository.count());
        perfilRepository.delete(cliente);
        assertEquals(0, perfilRepository.count());
    }
}
