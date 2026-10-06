package mx.edu.utez.cursos.controller;


import mx.edu.utez.cursos.model.Curso;
import mx.edu.utez.cursos.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoService cursoService;
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        return ResponseEntity.ok(cursoService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Curso>getById(@PathVariable Long id){
        Optional<Curso> curso = cursoService.findById(id);
        if(curso.isPresent()){
            return ResponseEntity.ok(curso.get());

        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Curso> save (@RequestBody Curso curso){
        cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable Long id){
        boolean deleted = cursoService.delete(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody
                                        Curso curso){
        Optional<Curso> optionalCurso = cursoService.update(id, curso);
        if(optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalCurso.get());
        }
        return ResponseEntity.notFound().build();
    }
}
