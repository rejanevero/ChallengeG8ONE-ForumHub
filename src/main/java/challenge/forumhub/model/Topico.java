package challenge.forumhub.model;

import challenge.forumhub.dto.topico.DadosTopicoAtualizacao;
import challenge.forumhub.dto.topico.DadosTopicoPostagem;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    public Topico(DadosTopicoPostagem dados, Usuario usuario, Curso curso) {
        this.titulo = dados.titulo().trim();
        this.mensagem = dados.mensagem().trim();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESOLVIDO;
        this.usuario = usuario;
        this.curso = curso;
    }

    public void atualizarInformacoes(DadosTopicoAtualizacao dados, Curso curso) {
        if (dados.titulo() != null) this.titulo = dados.titulo().trim();
        if (dados.mensagem() != null) this.mensagem = dados.mensagem().trim();
        if (curso != null) this.curso = curso;
    }

    public void finalizarTopico() {
        this.status = StatusTopico.RESOLVIDO;
    }

}
