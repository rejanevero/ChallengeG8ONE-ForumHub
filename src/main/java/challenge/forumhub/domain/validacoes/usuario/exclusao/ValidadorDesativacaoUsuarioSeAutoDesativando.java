package challenge.forumhub.domain.validacoes.usuario.exclusao;

import challenge.forumhub.service.AuthenticationService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDesativacaoUsuarioSeAutoDesativando implements ValidadorDesativacaoUsuario {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void validar(Long id) {
        if (id.equals(authenticationService.getUsuarioLogado().getId())){
            throw new ValidationException("Um usuário não pode se autodesativar!");
        }
    }
}
