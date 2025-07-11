package challenge.forumhub.service;

import challenge.forumhub.domain.validacoes.topico.atualizacao.ValidadorAtualizacaoTopico;
import challenge.forumhub.domain.validacoes.topico.postagem.ValidadorPostagemTopico;
import challenge.forumhub.dto.topico.DadosDetalhamentoTopico;
import challenge.forumhub.dto.topico.DadosTopicoAtualizacao;
import challenge.forumhub.dto.topico.DadosTopicoPostagem;
import challenge.forumhub.model.Curso;
import challenge.forumhub.model.Topico;
import challenge.forumhub.repository.CursoRepository;
import challenge.forumhub.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorPostagemTopico> validadorDePostagemDeTopicos;

    @Autowired
    private List<ValidadorAtualizacaoTopico> validadorDeAtualizacaoDeTopicos;

    public DadosDetalhamentoTopico postar(DadosTopicoPostagem dados) {
        if (!cursoRepository.existsById(dados.idCurso())) throw new ValidationException("Nenhum curso cadastrado com o ID informado!");

        validadorDePostagemDeTopicos.forEach(validador -> validador.validar(dados));

        var curso = cursoRepository.findById(dados.idCurso()).get();
        var usuario = AuthenticationService.getUsuarioLogado();
        var topico = new Topico(dados, usuario, curso);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizar(Long id, DadosTopicoAtualizacao dados) {
        if (!topicoRepository.existsById(id)) throw new ValidationException("Nenhum tópico encontrado com o ID informado!");

        Curso curso = null;
        if (dados.idCurso() != null){
            if (!cursoRepository.existsById(dados.idCurso())){
                throw new ValidationException("Nenhum curso cadastrado com o ID informado!");
            } else {
                curso = cursoRepository.getReferenceById(dados.idCurso());
            }
        }

        validadorDeAtualizacaoDeTopicos.forEach(validador -> validador.validar(id, dados));

        var topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacoes(dados, curso);

        return new DadosDetalhamentoTopico(topico);
    }
}
