package challenge.forumhub.domain.validacoes.usuario.atualizacao;

import challenge.forumhub.dto.usuario.DadosUsuarioAtualizacao;

public interface ValidadorAtualizacaoUsuario {

    void validar(DadosUsuarioAtualizacao dados);

}
