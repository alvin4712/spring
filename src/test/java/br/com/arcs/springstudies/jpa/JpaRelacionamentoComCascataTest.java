package br.com.arcs.springstudies.jpa;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.jdbc.Sql;

import br.com.arcs.springstudies.jpa.model.Editora;
import br.com.arcs.springstudies.jpa.model.Genero;
import br.com.arcs.springstudies.jpa.model.Livro;
import br.com.arcs.springstudies.jpa.repository.EditoraRepository;
import br.com.arcs.springstudies.jpa.repository.GeneroRepository;
import br.com.arcs.springstudies.jpa.repository.LivroRepository;

@SpringBootTest
@Sql("test-registries.sql")
public class JpaRelacionamentoComCascataTest {
    /*
     * Editora: cascade
     * Genero: no cascade
     */
    private Livro livro = new Livro(9788533302273l, "Titulo", 1, 1, null, null);
    private Genero genero = new Genero(1l, "Suspense");
    private Editora editora = new Editora(1l, "Ática", "Brasília");

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    GeneroRepository generoRepository;
    @Autowired
    EditoraRepository editoraRepository;

    @Test
    void relacionamentoComCascataTest() {
        /*
         * A editora (PK = 1) não pode ser encontrado na tabela,
         * pois ainda não foi salva e como a relação não está configurada para realizar
         * o cascateamento de persistência, o perfil não pode ser salvo automaticamente.
         * 
         * Portanto é lançada a exceção:
         * 
         * org.springframework.orm.jpa.JpaObjectRetrievalFailureException: Unable to
         * find br.com.arcs.springstudies.jpa.model.Genero with id 1
         * 
         * Caused by: jakarta.persistence.EntityNotFoundException: Unable to find
         * br.com.arcs.springstudies.jpa.model.Genero with id 1
         * 
         */
        livro.setEditora(editora);
        livro.setGenero(genero);
        assertThrows(JpaObjectRetrievalFailureException.class, () -> livroRepository.save(livro));

        // editoraRepository.save(editora);
        generoRepository.save(genero);
        assertDoesNotThrow(() -> livroRepository.save(livro));
    }
}
