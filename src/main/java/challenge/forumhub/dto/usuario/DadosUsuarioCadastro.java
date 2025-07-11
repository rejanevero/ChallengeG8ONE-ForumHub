package challenge.forumhub.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosUsuarioCadastro(
        @NotNull
        String nome,
        @NotNull
        @Email
        String email,
        @NotNull
        String senha
) {
}
