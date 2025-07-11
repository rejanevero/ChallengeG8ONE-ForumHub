package challenge.forumhub.service;

import challenge.forumhub.domain.validacoes.resposta.atualizacao.ValidadorAtualizacaoResposta;
import challenge.forumhub.domain.validacoes.resposta.exclusao.ValidadorExclusaoResposta;
import challenge.forumhub.domain.validacoes.resposta.postagem.ValidadorPostagemResposta;
import challenge.forumhub.dto.resposta.DadosDetalhamentoResposta;
import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;
import challenge.forumhub.dto.resposta.DadosRespostaPostagem;
import challenge.forumhub.model.Resposta;
import challenge.forumhub.repository.RespostaRepository;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorPostagemResposta> validadorDePostagemDeResposta;

    @Autowired
    private List<ValidadorAtualizacaoResposta> validadorDeAtualizacaoRespostas;

    @Autowired
    private List<ValidadorExclusaoResposta> validadorDeExclusaoRespostas;

    public DadosDetalhamentoResposta postar(Long idTopico, DadosRespostaPostagem dados) {
        if (!topicoRepository.existsById(idTopico)) throw new ValidationException("Nenhum tópico encontrado com o ID fornecido!");

        validadorDePostagemDeResposta.forEach(validador -> validador.validar(idTopico, dados));

        var topico = topicoRepository.getReferenceById(idTopico);
        var resposta = new Resposta(topico, dados);

        respostaRepository.save(resposta);

        return new DadosDetalhamentoResposta(resposta);
    }

    public DadosDetalhamentoResposta atualizar(Long idResposta, DadosRespostaAtualizacao dados) {
        if (!respostaRepository.existsById(idResposta)) throw new ValidationException("Nenhuma resposta encontrada com o ID fornecido!");

        validadorDeAtualizacaoRespostas.forEach(validador -> validador.validar(idResposta, dados));
        var resposta = respostaRepository.getReferenceById(idResposta);
        resposta.atualizar(dados);

        return new DadosDetalhamentoResposta(resposta);
    }

    public void excluir(Long idResposta) {
        if (!respostaRepository.existsById(idResposta)) throw new ValidationException("Nenhuma resposta encontrada com o ID fornecido!");

        validadorDeExclusaoRespostas.forEach(validador -> validador.validar(idResposta));

        respostaRepository.deleteById(idResposta);
    }

}
