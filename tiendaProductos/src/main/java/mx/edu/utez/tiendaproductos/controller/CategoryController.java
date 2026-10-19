
package mx.edu.utez.tiendaproductos.controller;

import jakarta.validation.Valid;
import mx.edu.utez.tiendaproductos.dto.CategoryRequest;
import mx.edu.utez.tiendaproductos.dto.CategoryResponse;
import mx.edu.utez.tiendaproductos.model.Category;
import mx.edu.utez.tiendaproductos.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        List<CategoryResponse> listResponse = new ArrayList<>();

        for (Category category : service.getAll()) {
            listResponse.add(toResponse(category));
        }

        return ResponseEntity.ok(listResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        Category category = service.findById(id);

        return ResponseEntity.ok(toResponse(category));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(
            @Valid @RequestBody CategoryRequest request) {

        Category category = service.save(toEntity(request));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request) {

        Category category = service.update(id, toEntity(request));

        return ResponseEntity.ok(toResponse(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    private CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    private Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        return category;
    }
}
