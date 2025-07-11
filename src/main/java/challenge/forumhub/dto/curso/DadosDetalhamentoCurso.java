package challenge.forumhub.dto.curso;

import challenge.forumhub.model.CategoriaCurso;
import challenge.forumhub.model.Curso;

public record DadosDetalhamentoCurso(
        Long idCurso,
        String nomeCurso,
        CategoriaCurso categoriaCurso
) {
    public DadosDetalhamentoCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
