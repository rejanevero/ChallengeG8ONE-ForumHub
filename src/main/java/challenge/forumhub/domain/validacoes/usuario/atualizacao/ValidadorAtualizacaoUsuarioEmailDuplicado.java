package challenge.forumhub.domain.validacoes.usuario.atualizacao;

import challenge.forumhub.dto.usuario.DadosUsuarioAtualizacao;
import challenge.forumhub.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoUsuarioEmailDuplicado implements ValidadorAtualizacaoUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosUsuarioAtualizacao dados) {
        if (dados.email() != null && usuarioRepository.existsByEmail(dados.email().trim())){
            throw new ValidationException("Já existe um usuário cadastrado com o email informado!");
        }
    }
}
