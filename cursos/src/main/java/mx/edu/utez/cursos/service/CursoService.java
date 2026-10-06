package mx.edu.utez.cursos.service;


import mx.edu.utez.cursos.model.Curso;
import mx.edu.utez.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private CursoRepository cursoRepo;
    public CursoService(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }
    public List<Curso> getAll(){
        return cursoRepo.findAll();
    }

    public Optional<Curso> findById(Long id){
        return cursoRepo.findById(id);
    }
    public Curso save(Curso curso){
        return cursoRepo.save(curso);
    }
    public Optional<Curso>update(long id, Curso curso){
        Optional<Curso> optional = cursoRepo.findById(id);
        if(optional.isEmpty()){
            return optional.empty();
        }
        Curso cursoDB = optional.get();
        cursoDB.setNombre(curso.getNombre());
        cursoDB.setInstructor(curso.getInstructor());
        cursoDB.setDuracion(curso.getDuracion());

        return Optional.of(cursoRepo.save(cursoDB));
    }

    public boolean delete(Long id){
        if(!cursoRepo.existsById(id)){
            return false;
        }
        cursoRepo.deleteById(id);
        return true;
    }
}
