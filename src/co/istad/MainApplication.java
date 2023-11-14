package co.istad;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.dto.CreateProduct;
import co.istad.dto.UpdateProduct;
import co.istad.util.Singleton;

import java.util.Scanner;

import static java.lang.System.exit;

public class MainApplication {
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;

    public MainApplication() {
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();
    }

    public void run() {
        while(true) {
            System.out.println("Options:");
            menuController.index();
            System.out.println("Welcome to PMS");
            System.out.print("Enter option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> productController.index();
                case 2 -> {
                    System.out.println();
                    System.out.println("Create Product");
                    System.out.print("Enter Product ID: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Qty: ");
                    Integer qty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Product Price: ");
                    Double price = Double.parseDouble(scanner.nextLine());
                    CreateProduct createProduct = new CreateProduct(id, name, qty, price);
                    productController.createProduct(createProduct);
                    System.out.println();
                    System.out.println("Product has been added successfully!");
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("Update Product");
                    System.out.print("Enter ID to update: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Product Qty: ");
                    Integer newQty = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter New Product Price: ");
                    Double newPrice = Double.parseDouble(scanner.nextLine());
                    UpdateProduct updateProduct = new UpdateProduct(newName, newQty, newPrice);
                    productController.updateProduct(id, updateProduct);
                    System.out.println();
                    System.out.println("Product has been updated successfully!");
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    System.out.print("Enter ID to delete: ");
                    Long foundId = Long.parseLong(scanner.nextLine());
                    productController.deleteById(foundId);
                    System.out.println();
                    System.out.println("Product ID " + foundId + " has been deleted successfully!");
                    System.out.println();
                }
                case 5 -> exit(0);
                default -> throw new IllegalArgumentException();
            }
        }

    }
    public static void main(String[] args) {

        new MainApplication().run();
    }
}
