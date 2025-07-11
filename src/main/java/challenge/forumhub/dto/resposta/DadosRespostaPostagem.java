package challenge.forumhub.dto.resposta;

import jakarta.validation.constraints.NotNull;

public record DadosRespostaPostagem(
        @NotNull
        String mensagem,
        @NotNull
        String solucao
) {
}
