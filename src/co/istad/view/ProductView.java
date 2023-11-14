package co.istad.view;

import co.istad.model.Product;

import java.util.List;
import static java.lang.System.*;
public class ProductView {
    public static void printProductList(List<Product> products) {
        out.println();
        out.println("Product List");
        products.forEach(pro -> {
            out.println("ID: " + pro.getId());
            out.println("NAME: " + pro.getName());
            out.println("QTY: " + pro.getQty());
            out.println("PRICE: " + pro.getPrice());
            out.println("IMPORTED DATE: " + pro.getImportedDate());
            out.println();
        });
    }
}
