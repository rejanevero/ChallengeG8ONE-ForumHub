package challenge.forumhub.dto.topico;

import challenge.forumhub.dto.usuario.DadosDetalhamentoUsuario;
import challenge.forumhub.model.Curso;
import challenge.forumhub.model.StatusTopico;
import challenge.forumhub.model.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        DadosDetalhamentoUsuario usuario,
        Curso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), new DadosDetalhamentoUsuario(topico.getUsuario()), topico.getCurso());
    }
}
