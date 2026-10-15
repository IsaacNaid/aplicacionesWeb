package mx.edu.utez.tiendaproductos.repository;

import mx.edu.utez.tiendaproductos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
