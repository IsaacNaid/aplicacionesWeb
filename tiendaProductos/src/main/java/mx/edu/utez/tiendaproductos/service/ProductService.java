package mx.edu.utez.tiendaproductos.service;


import mx.edu.utez.tiendaproductos.model.Category;
import mx.edu.utez.tiendaproductos.model.Product;
import mx.edu.utez.tiendaproductos.repository.CategoryRepository;
import mx.edu.utez.tiendaproductos.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;
    private final CategoryRepository repoCategory;
    public ProductService(ProductRepository repo ,  CategoryRepository repoCategory){
        this.repo = repo;
        this.repoCategory= repoCategory;
    }

    public List<Product> getAll(){
        return repo.findAll();
    }

    public Optional<Product> findById(Long id){
        return repo.findById(id);
    }

    public Product save(Product product,long categoryId){
        Category category = repoCategory.findById(categoryId).orElseThrow();
        product.setCategory(category);
        return repo.save(product);

    }

    public Optional<Product> update(long id, Product product){
        Optional<Product> optional = repo.findById(id);
        if(optional.isEmpty()){
            return optional.empty();
        }
        Product productDB = optional.get();
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        return Optional.of(repo.save(productDB));
    }

    public boolean delete(long id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
