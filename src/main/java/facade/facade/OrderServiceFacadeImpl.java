package facade.facade;

import facade.Product;
import facade.facade.OrderServiceFacade;
import facade.services.InventoryService;
import facade.services.PaymentService;
import facade.services.ShippingService;

/**
 * Created by Michał Gębarowski on 5/08/2018
 */
public class OrderServiceFacadeImpl implements OrderServiceFacade {

    @Override
    public boolean placeOrder(int productId) {
        boolean orderFulfilled = false;
        Product product = new Product(productId, "ProductName");
        if (InventoryService.isAvailable(product)) {
            System.out.println("Product with ID " + product.productId + " is available");
            boolean paymentConfirmed = PaymentService.makePayment();
            if (paymentConfirmed) {
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(product);
                System.out.println("Product shipped...");
                orderFulfilled = true;
            }
        }
        return orderFulfilled;
    }
}
