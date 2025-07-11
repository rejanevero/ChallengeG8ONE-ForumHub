package challenge.forumhub.dto.topico;

import jakarta.validation.constraints.NotNull;

public record DadosTopicoPostagem(
        @NotNull
        String titulo,
        @NotNull
        String mensagem,
        @NotNull
        Long idCurso
) {
}
