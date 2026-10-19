
package mx.edu.utez.tiendaproductos.service;

import mx.edu.utez.tiendaproductos.exception.ResourceNotFoundException;
import mx.edu.utez.tiendaproductos.model.Category;
import mx.edu.utez.tiendaproductos.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with ID: " + id
                ));
    }

    public Category save(Category category) {
        return repo.save(category);
    }

    public Category update(Long id, Category category) {
        Category categoryDB = findById(id);

        categoryDB.setName(category.getName());

        return repo.save(categoryDB);
    }

    public void delete(Long id) {
        Category category = findById(id);
        repo.delete(category);
    }
}
