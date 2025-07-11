package challenge.forumhub.dto.usuario;

import jakarta.validation.constraints.Email;

public record DadosUsuarioAtualizacao(
        String nome,
        @Email
        String email,
        String senha
) {
}
