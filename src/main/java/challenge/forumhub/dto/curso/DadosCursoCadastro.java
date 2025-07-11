package challenge.forumhub.dto.curso;

import challenge.forumhub.model.CategoriaCurso;
import jakarta.validation.constraints.NotNull;

public record DadosCursoCadastro(
        @NotNull
        String nome,
        @NotNull
        CategoriaCurso categoriaCurso
) {
}
