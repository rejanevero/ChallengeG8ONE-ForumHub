package challenge.forumhub.service;

import challenge.forumhub.dto.curso.DadosCursoCadastro;
import challenge.forumhub.dto.curso.DadosDetalhamentoCurso;
import challenge.forumhub.model.Curso;
import challenge.forumhub.repository.CursoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public DadosDetalhamentoCurso cadastrar(DadosCursoCadastro dados) {
        if (cursoRepository.existsByNomeIgnoreCase(dados.nome().trim())) throw new ValidationException("Já existe um curso cadastrado com o nome informado!");
        var curso = new Curso(dados);
        cursoRepository.save(curso);

        return new DadosDetalhamentoCurso(curso);
    }
}
