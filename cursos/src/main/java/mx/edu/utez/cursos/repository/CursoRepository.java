package mx.edu.utez.cursos.repository;

import mx.edu.utez.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
