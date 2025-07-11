package challenge.forumhub.service;

import challenge.forumhub.domain.validacoes.usuario.atualizacao.ValidadorAtualizacaoUsuario;
import challenge.forumhub.domain.validacoes.usuario.cadastro.ValidadorCadastroUsuario;
import challenge.forumhub.domain.validacoes.usuario.exclusao.ValidadorDesativacaoUsuario;
import challenge.forumhub.dto.usuario.DadosDetalhamentoUsuario;
import challenge.forumhub.dto.usuario.DadosUsuarioAtualizacao;
import challenge.forumhub.dto.usuario.DadosUsuarioCadastro;
import challenge.forumhub.model.Usuario;
import challenge.forumhub.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorCadastroUsuario> validadorDeCadastroDeUsuarios;

    @Autowired
    private List<ValidadorAtualizacaoUsuario> validadorDeAtualizacaoUsuario;

    @Autowired
    private List<ValidadorDesativacaoUsuario> validadorDeDesativacaoDeUsuarios;

    public Page listar(Pageable paginacao, Boolean ativo) {
        Page page = null;
        if (ativo){
            page = usuarioRepository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoUsuario::new);
        } else {
            page  = usuarioRepository.findAll(paginacao).map(DadosDetalhamentoUsuario::new);
        }
        return page;
    }

    public DadosDetalhamentoUsuario cadastrar(DadosUsuarioCadastro dados) {
        validadorDeCadastroDeUsuarios.forEach(validador -> validador.validar(dados));

        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return new DadosDetalhamentoUsuario(usuario);
    }

    public void desativar(Long id) {
        if (!usuarioRepository.existsById(id)) throw new ValidationException("Nenhum usuário encontrado com o ID fornecido!");
        validadorDeDesativacaoDeUsuarios.forEach(validador -> validador.validar(id));
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.desativar();
    }

    public DadosDetalhamentoUsuario atualizar(Long id, DadosUsuarioAtualizacao dados) {
        if (!usuarioRepository.existsById(id)) throw new ValidationException("Nenhum usuário encontrado com o ID fornecido!");
        validadorDeAtualizacaoUsuario.forEach(validador -> validador.validar(dados));
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizar(dados);
        return new DadosDetalhamentoUsuario(usuario);
    }

}
