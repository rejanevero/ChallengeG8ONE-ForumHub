package challenge.forumhub.domain.validacoes.topico.atualizacao;

import challenge.forumhub.dto.topico.DadosTopicoAtualizacao;
import challenge.forumhub.model.StatusTopico;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoTopicoResolvido implements ValidadorAtualizacaoTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao) {
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(id).getStatus())){
            throw new ValidationException("Tópicos resolvidos não podem ser atualizados!");
        }
    }
}
