package challenge.forumhub.domain.validacoes.usuario.cadastro;

import challenge.forumhub.dto.usuario.DadosUsuarioCadastro;

public interface ValidadorCadastroUsuario {

    void validar(DadosUsuarioCadastro dados);

}
