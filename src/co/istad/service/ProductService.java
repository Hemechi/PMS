package co.istad.service;

import co.istad.dto.UpdateProduct;
import co.istad.model.Product;

import java.util.List;

public interface ProductService {
    Product insert(Product product);

    List<Product> select();

    Product selectedById(Long id);

        Product updateById(String id, UpdateProduct updateProduct);

    Product deleteById(Long id);

    List<Product> selectByName(String name);
}
