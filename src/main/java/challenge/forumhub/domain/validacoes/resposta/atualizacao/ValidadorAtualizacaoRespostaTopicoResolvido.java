package challenge.forumhub.domain.validacoes.resposta.atualizacao;

import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;
import challenge.forumhub.model.StatusTopico;
import challenge.forumhub.repository.RespostaRepository;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaTopicoResolvido implements ValidadorAtualizacaoResposta {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        var resposta = respostaRepository.getReferenceById(idResposta);
        if (StatusTopico.RESOLVIDO.equals(topicoRepository.getReferenceById(resposta.getTopico().getId()).getStatus())){
            throw new ValidationException("Tópicos resolvidos não permitem edição de suas respostas!");
        }
    }
}
