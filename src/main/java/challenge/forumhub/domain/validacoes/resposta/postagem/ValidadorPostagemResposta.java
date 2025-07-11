package challenge.forumhub.domain.validacoes.resposta.postagem;

import challenge.forumhub.dto.resposta.DadosRespostaPostagem;

public interface ValidadorPostagemResposta {

    void validar(Long idTopico, DadosRespostaPostagem dadosRespostaPostagem);

}
