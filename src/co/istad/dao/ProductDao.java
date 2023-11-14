package co.istad.dao;

import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    // CRUD = Create, Read, Update and Delete

    Product insert(Product product);

    List<Product> select();

    Optional<Product> selectedById(Long id);

    Product updateById(Product product);

    Product deleteById(Long id);

    List<Product> selectByName(String name);
}
