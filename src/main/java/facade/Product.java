package facade;

/**
 * Created by Michał Gębarowski on 3/08/2018
 */
public class Product {

    public int productId;
    public String productName;

    public Product() {
    }

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}
