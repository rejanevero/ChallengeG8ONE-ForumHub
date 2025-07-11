package challenge.forumhub.domain.validacoes.topico.atualizacao;

import challenge.forumhub.dto.topico.DadosTopicoAtualizacao;

public interface ValidadorAtualizacaoTopico {

    void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao);

}
