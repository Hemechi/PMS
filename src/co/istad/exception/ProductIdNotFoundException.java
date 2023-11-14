package co.istad.exception;

public class ProductIdNotFoundException extends RuntimeException {
    public ProductIdNotFoundException(String name) {
        super(name);
    }
}
