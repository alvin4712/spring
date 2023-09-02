package br.com.arcs.springstudies.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import br.com.arcs.springstudies.jpa.model.Livro;
import br.com.arcs.springstudies.jpa.repository.ExemplarRepository;
import br.com.arcs.springstudies.jpa.repository.LivroRepository;

@SpringBootTest
@Sql("test-registries.sql")
public class JpaRelacionamentoComCascata {
    private Livro livro = new Livro();
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    ExemplarRepository exemplarRepository;
}
