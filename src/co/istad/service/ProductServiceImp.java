package co.istad.service;

import co.istad.dao.ProductDao;
import co.istad.dao.ProductDaoImpl;
import co.istad.dto.UpdateProduct;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImp implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImp() {
        productDao = new ProductDaoImpl();
    }
    @Override
    public Product insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    public Product selectedById(Long id) {
        return productDao.selectedById(id).orElseThrow(()
                -> new ProductIdNotFoundException(
                String.format("Product ID = %s does not exist in DB!", id)));
    }

    @Override
    public Product updateById(String id, UpdateProduct updateProduct) {
        Optional<Product> optionalProduct = productDao.selectedById(Long.valueOf(id));
        Product product = optionalProduct.get();
        product.setName(updateProduct.getName());
        product.setQty(updateProduct.getQty());
        product.setPrice(updateProduct.getPrice());
        return productDao.updateById(product);
    }

    @Override
    public Product deleteById(Long id) {
        return productDao.deleteById(id);
    }

    @Override
    public List<Product> selectByName(String name) {
        return productDao.selectByName(name);
    }
}
