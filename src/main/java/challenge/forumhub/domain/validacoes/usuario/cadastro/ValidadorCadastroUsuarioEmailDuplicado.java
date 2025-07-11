package challenge.forumhub.domain.validacoes.usuario.cadastro;

import challenge.forumhub.dto.usuario.DadosUsuarioCadastro;
import challenge.forumhub.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCadastroUsuarioEmailDuplicado implements ValidadorCadastroUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DadosUsuarioCadastro dados) {
        if (usuarioRepository.existsByEmail(dados.email().trim())){
            throw new ValidationException("Já existe um usuário cadastrado com o email informado!");
        }
    }
}
