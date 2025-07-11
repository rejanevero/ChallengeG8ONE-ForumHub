package challenge.forumhub.domain.validacoes.resposta.postagem;

import challenge.forumhub.dto.resposta.DadosRespostaPostagem;
import challenge.forumhub.repository.RespostaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPostagemRespostaSolucaoRepetida implements ValidadorPostagemResposta {

    @Autowired
    private RespostaRepository respostaRepository;

    @Override
    public void validar(Long idTopico, DadosRespostaPostagem dadosRespostaPostagem) {
        if (respostaRepository.optionalRespostaByIdTopicoAndSolucaoIgnoreCase(idTopico, dadosRespostaPostagem.solucao().trim()).isPresent()){
            throw new ValidationException("Já existe uma resposta para este tópico com essa solução!");
        }
    }
}
