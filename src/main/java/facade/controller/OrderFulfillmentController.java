package facade.controller;

import facade.facade.OrderServiceFacade;

/**
 * Created by Michał Gębarowski on 5/08/2018
 */
public class OrderFulfillmentController {

    OrderServiceFacade facade;
    boolean orderFulfilled = false;

    public void orderProduct(int productId) {
        orderFulfilled = facade.placeOrder(productId);
        System.out.println("OrderFulfillmentController: Order fulfillment complected");
    }
}

