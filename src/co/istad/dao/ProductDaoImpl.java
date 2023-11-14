package co.istad.dao;

import co.istad.database.ProductDatabase;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    private final ProductDatabase productDatabase;
    public ProductDaoImpl() {
        productDatabase = new ProductDatabase();
    }
    @Override
    public Product insert(Product product) {
        productDatabase.getAllProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {
        return productDatabase.getAllProducts();
    }

    @Override
    public Optional<Product> selectedById(Long id) {
        return productDatabase.getAllProducts().stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst();
    }

    @Override
    public Product updateById(Product product) {
        return productDatabase.getAllProducts().stream()
                .filter(pro -> pro.getId().equals(product.getId()))
                .map(newPro -> product)
                .findFirst()
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                                String.format("Product ID = %s does not exist in DB!", product.getId())));
    }

    @Override
    public Product deleteById(Long id) {
        Product foundProduct = productDatabase.getAllProducts().stream()
                .filter(pro -> pro.getId().equals(id))
                .findFirst()
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                        String.format("Product ID = %s does not exist in DB!", id)));
        productDatabase.getAllProducts().remove(foundProduct);
        return foundProduct;
    }

    @Override
    public List<Product> selectByName(String name) {
        return productDatabase.getAllProducts().stream()
                .filter(pro -> pro.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
