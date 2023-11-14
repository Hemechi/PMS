package co.istad.util;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.service.ProductServiceImp;

import java.util.Scanner;

public class Singleton {
    // 1. Create static reference type
    public static Scanner scanner;

    public static MenuController menuController;

    public static ProductController productController;

    public static ProductServiceImp productServiceImp;
    // 2. Create get instance

    public static Scanner scanner() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    public static MenuController menuController() {
        if(menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }
    public static ProductController productController() {
        if(productController == null) {
            productController = new ProductController();
        }
        return productController;
    }
    public static ProductServiceImp productServiceImp() {
        if(productServiceImp == null) {
            productServiceImp = new ProductServiceImp();
        }
        return productServiceImp;
    }
}
