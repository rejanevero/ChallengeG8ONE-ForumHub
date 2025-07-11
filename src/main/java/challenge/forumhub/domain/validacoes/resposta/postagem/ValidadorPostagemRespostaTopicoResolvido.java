package challenge.forumhub.domain.validacoes.resposta.postagem;

import challenge.forumhub.dto.resposta.DadosRespostaPostagem;
import challenge.forumhub.model.StatusTopico;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPostagemRespostaTopicoResolvido implements ValidadorPostagemResposta {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long idTopico, DadosRespostaPostagem dadosRespostaPostagem) {
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(idTopico).getStatus())){
            throw new ValidationException("Tópicos resolvidos não podem receber novas respostas!");
        }
    }
}
