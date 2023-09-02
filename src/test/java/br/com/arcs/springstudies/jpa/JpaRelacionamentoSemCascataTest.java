package br.com.arcs.springstudies.jpa;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.jdbc.Sql;

import br.com.arcs.springstudies.jpa.model.Perfil;
import br.com.arcs.springstudies.jpa.model.Usuario;
import br.com.arcs.springstudies.jpa.repository.PerfilRepository;
import br.com.arcs.springstudies.jpa.repository.UsuarioRepository;

@SpringBootTest
@Sql("test-registries.sql")
public class JpaRelacionamentoSemCascataTest {
    private static final List<Perfil> PERFIS = List.of(
            new Perfil(1l, null, null, null),
            new Perfil(2l, "CLIENTE", 2, 10));
    private static final List<Usuario> USUARIOS = List.of(
            new Usuario("24772054159", "Marcos",
                    "Brasília",
                    "m@gm.com", null),
            new Usuario("03602898547", "José",
                    "Brasília",
                    "j@j.com", null),
            new Usuario("03602898547", "José",
                    "Brasília",
                    "j@j.com", null),
            new Usuario("03602823547", "Vitor",
                    "Brasília",
                    "v@v.com", null));

//     @Autowired
//     AutoriaRepository autoriaRepository;
//     @Autowired
//     AutorRepository autorRepository;
//     @Autowired
//     EditoraRepository editoraRepository;
//     @Autowired
//     EmprestimoRepository emprestimoRepository;
//     @Autowired
//     ExemplarRepository exemplarRepository;
//     @Autowired
//     GeneroRepository generoRepository;
//     @Autowired
//     LivroRepository livroRepository;
    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    Perfil perfil;

    @Test
    void persistenciaRelacionamentoSemCascataTest() {
        Perfil funcionario = PERFIS.get(0);
        Perfil cliente = PERFIS.get(1);
        Usuario usuario1 = USUARIOS.get(0);
        Usuario usuario2 = USUARIOS.get(1);
        Usuario usuario3 = USUARIOS.get(2);
        Usuario usuario4 = USUARIOS.get(3);

        /*
         * O perfil cliente(PK = 2) não pode ser encontrado na tabela,
         * pois ainda não foi salva e como a relação não está configurada para realizar
         * o cascateamento de persistência, o perfil não pode ser salvo automaticamente.
         * 
         * Portanto é lançada a exceção:
         * 
         * org.springframework.orm.jpa.JpaObjectRetrievalFailureException: Unable to
         * find br.com.arcs.springstudies.jpa.model.Perfil with id 2
         * 
         * Caused by: jakarta.persistence.EntityNotFoundException: Unable to find
         * br.com.arcs.springstudies.jpa.model.Perfil with id 2
         * 
         */
        usuario1.setPerfil(cliente);
        assertThrows(JpaObjectRetrievalFailureException.class, () -> usuarioRepository.save(usuario1));

        /*
         * Em uma nova tentativa, com o perfil funcionário(PK = 1), que já foi
         * persistido pelo script inicial, nenhuma exceção é
         * lançada e o usuário (PK = "24772054159") é persistido normalmente.
         * 
         * Obs.: mesmo com uma objeto Pefil incompleto, que contém apenas o id(codigo),
         * o JpaRepository consegue fazer a persistência da relação.
         */
        usuario1.setPerfil(funcionario);
        assertDoesNotThrow(() -> usuarioRepository.save(usuario1));
        Usuario usuario1Salvo = usuarioRepository.findById(usuario1.getCpf()).get();
        assertEquals(1, usuario1Salvo.getPerfil().getCodigo());

        /*
         * Após salvar o perfil CLIENTE, há três formas de recuperar uma instância desse
         * perfil para poder utilizar como objeto da relação.
         * 
         * Após salvar uma entidade, o método save devolve a instância com o objeto
         * salvo.
         * Obs.: Caso a PK seja criada pelo banco, o objeto deverá ser capturado para
         * que se possa saber o valor da PK gerada.
         * 
         * getReferenceById X findById
         * 
         * A diferença entre eles acontece "por baixo dos panos", sendo um detalhe da
         * JPA e não do Spring em si:
         * 
         * getReferenceById chama o método getReference do EntityManager, que lança uma
         * exception se a entidade não existir no banco de dados. Caso ela exista, um
         * proxy será devolvido e não a entidade em si(carregamento LAZY).
         * 
         * findById chama o método find do EntityManager, que retorna null se a entidade
         * não existir no banco de dados. Caso ela exista, será carregada completa do
         * banco e devolvida(carregamento EAGER).
         * 
         * Se você está carregando uma entidade apenas para a relacionar com outra
         * entidade, sem a necessidade de acessar os atributos dela, então o ideal é
         * chamar o método getReferenceById.
         */
        Perfil managedPerfil = perfilRepository.save(cliente);
        usuario2.setPerfil(managedPerfil);
        usuarioRepository.save(usuario2);

        Perfil referecePerfil = perfilRepository.getReferenceById(cliente.getCodigo());
        usuario3.setPerfil(referecePerfil);
        usuarioRepository.save(usuario3);

        Perfil findedByIdPerfil = perfilRepository.findById(cliente.getCodigo()).get();
        usuario4.setPerfil(findedByIdPerfil);
        usuarioRepository.save(usuario4);

        /*
         * [
         *  Usuario(
         *      cpf=24772054159,
         *      nome=Marcos,
         *      endereco=Brasília,
         *      email=m@gm.com,
         *      perfil=Perfil(
         *          codigo=1,
         *          nome=FUNCIONÁRIO,
         *          limite=5,
         *          prazo=30)
         *      ),
         * Usuario(
         *      cpf=03602898547,
         *      nome=José,
         *      endereco=Brasília,
         *      email=j@j.com,
         *      perfil=Perfil(
         *          codigo=2,
         *          nome=CLIENTE,
         *          limite=2,
         *          prazo=10)
         *      ),
         * Usuario(
         *      cpf=03602823547,
         *      nome=Vitor,
         *      endereco=Brasília,
         *      email=v@v.com,
         *      perfil=Perfil(
         *          codigo=2,
         *          nome=CLIENTE,
         *          limite=2,
         *          prazo=10)
         *      )
         * ]
         */
        assertEquals(
                "[Usuario(cpf=24772054159, nome=Marcos, endereco=Bras\u00EDlia, email=m@gm.com, perfil=Perfil(codigo=1, nome=FUNCION\u00C1RIO, limite=5, prazo=30)), Usuario(cpf=03602898547, nome=Jos\u00E9, endereco=Bras\u00EDlia, email=j@j.com, perfil=Perfil(codigo=2, nome=CLIENTE, limite=2, prazo=10)), Usuario(cpf=03602823547, nome=Vitor, endereco=Bras\u00EDlia, email=v@v.com, perfil=Perfil(codigo=2, nome=CLIENTE, limite=2, prazo=10))]",
                usuarioRepository.findAll().toString());
    }

}
