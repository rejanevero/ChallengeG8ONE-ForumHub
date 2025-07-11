package challenge.forumhub.repository;

import challenge.forumhub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    boolean existsByNomeIgnoreCase(String nome);
}
