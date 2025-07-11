package challenge.forumhub.domain.validacoes.resposta.atualizacao;

import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;
import challenge.forumhub.repository.RespostaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAtualizacaoRespostaSolucaoRepetida implements ValidadorAtualizacaoResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idResposta, DadosRespostaAtualizacao dadosRespostaAtualizacao) {
        var resposta = respostaRepository.getReferenceById(idResposta);
        if (dadosRespostaAtualizacao.solucao() != null && respostaRepository.optionalRespostaByIdTopicoAndSolucaoIgnoreCase(resposta.getTopico().getId(), dadosRespostaAtualizacao.solucao().trim()).isPresent()){
            throw new ValidationException("Já existe uma resposta para este tópico com essa solução!");
        }
    }
}
