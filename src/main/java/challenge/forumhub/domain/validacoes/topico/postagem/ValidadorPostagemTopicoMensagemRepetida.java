package challenge.forumhub.domain.validacoes.topico.postagem;

import challenge.forumhub.dto.topico.DadosTopicoPostagem;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPostagemTopicoMensagemRepetida implements ValidadorPostagemTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosTopicoPostagem dadosTopicoPostagem) {
        if (topicoRepository.existsByMensagemIgnoreCase(dadosTopicoPostagem.mensagem().trim())) {
            throw new ValidationException("Já existe um tópico criado com essa mensagem!");
        }
    }
}
