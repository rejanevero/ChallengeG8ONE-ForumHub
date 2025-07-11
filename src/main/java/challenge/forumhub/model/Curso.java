package challenge.forumhub.model;

import challenge.forumhub.dto.curso.DadosCursoCadastro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="Curso")
@Table(name="cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoria;

    public Curso(DadosCursoCadastro dados) {
        this.nome = dados.nome().trim();
        this.categoria = dados.categoriaCurso();
    }
}
