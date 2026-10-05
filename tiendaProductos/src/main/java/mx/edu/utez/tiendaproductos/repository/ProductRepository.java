package mx.edu.utez.tiendaproductos.repository;

import mx.edu.utez.tiendaproductos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}