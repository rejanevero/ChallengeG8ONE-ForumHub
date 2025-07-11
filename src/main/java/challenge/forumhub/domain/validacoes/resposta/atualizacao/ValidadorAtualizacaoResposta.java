package challenge.forumhub.domain.validacoes.resposta.atualizacao;

import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;

public interface ValidadorAtualizacaoResposta {

    void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao);

}
