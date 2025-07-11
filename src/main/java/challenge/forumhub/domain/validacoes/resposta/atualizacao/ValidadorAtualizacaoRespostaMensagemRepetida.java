package challenge.forumhub.domain.validacoes.resposta.atualizacao;

import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;
import challenge.forumhub.repository.RespostaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaMensagemRepetida implements ValidadorAtualizacaoResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        var resposta = respostaRepository.getReferenceById(idResposta);
        if (dadosRespostaAtualizacao.mensagem() != null && respostaRepository.optionalRespostaByIdTopicoAndMensagemIgnoreCase(resposta.getTopico().getId(), dadosRespostaAtualizacao.mensagem().trim()).isPresent()){
            throw new ValidationException("Já existe uma resposta para este tópico com essa mensagem!");
        }
    }
}
