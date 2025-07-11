package challenge.forumhub.model;

import challenge.forumhub.dto.resposta.DadosRespostaAtualizacao;
import challenge.forumhub.dto.resposta.DadosRespostaPostagem;
import challenge.forumhub.service.AuthenticationService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Resposta")
@Table(name="respostas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String solucao;

    public Resposta(Topico topico, DadosRespostaPostagem dados) {
        this.mensagem = dados.mensagem().trim();
        this.topico = topico;
        this.dataCriacao = LocalDateTime.now();
        this.usuario = AuthenticationService.getUsuarioLogado();
        this.solucao = dados.solucao().trim();
    }

    public void atualizar(DadosRespostaAtualizacao dados){
        if (dados.mensagem() != null) this.mensagem = dados.mensagem();
        if (dados.solucao() != null) this.solucao = dados.solucao();
    }
}
