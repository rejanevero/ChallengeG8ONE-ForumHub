package challenge.forumhub.domain.validacoes.topico.atualizacao;

import challenge.forumhub.dto.topico.DadosTopicoAtualizacao;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoTopicoMensagemRepetida implements ValidadorAtualizacaoTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dadosTopicoAtualizacao) {
        if (dadosTopicoAtualizacao.mensagem() != null && topicoRepository.existsByMensagemIgnoreCase(dadosTopicoAtualizacao.mensagem().trim())) {
            throw new ValidationException("Já existe um tópico criado com essa mensagem!");
        }
    }
}
