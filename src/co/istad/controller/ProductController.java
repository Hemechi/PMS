package co.istad.controller;

import co.istad.dto.CreateProduct;
import co.istad.dto.UpdateProduct;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImp;
import co.istad.view.ProductView;

import java.time.LocalDate;
import java.util.List;

public class ProductController {
    private ProductService productService;

    public ProductController() {
        productService = new ProductServiceImp();
    }

    public void index() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

    public void createProduct(CreateProduct createProductDto) {
        Product createProduct = new Product(createProductDto.getId(), createProductDto.getName(), createProductDto.getQty(), createProductDto.getPrice(), LocalDate.now());
        productService.insert(createProduct);
    }

    public Product updateProduct(String id, UpdateProduct updateProduct) {
        return productService.updateById(id, updateProduct);
    }

    public void deleteById(Long id) {
        productService.deleteById(id);
    }
}
