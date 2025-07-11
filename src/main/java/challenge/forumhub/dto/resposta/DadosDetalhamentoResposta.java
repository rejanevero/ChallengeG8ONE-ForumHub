package challenge.forumhub.dto.resposta;

import challenge.forumhub.model.Resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        Long idTopico,
        String mensagem,
        LocalDateTime dataCriacao,
        Long idUsuario,
        String solucao
) {
    public DadosDetalhamentoResposta(Resposta resposta){
        this(resposta.getId(), resposta.getTopico().getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.getUsuario().getId(), resposta.getSolucao());
    }
}
