package challenge.forumhub.domain.validacoes.resposta.exclusao;

import challenge.forumhub.model.StatusTopico;
import challenge.forumhub.repository.RespostaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorExclusaoRespostaTopicoResolvido implements ValidadorExclusaoResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idResposta) {
        if (StatusTopico.RESOLVIDO.equals(respostaRepository.getReferenceById(idResposta).getTopico().getStatus())){
            throw new ValidationException("Tópicos resolvidos não permitem exlusão de respostas!");
        }
    }
}
