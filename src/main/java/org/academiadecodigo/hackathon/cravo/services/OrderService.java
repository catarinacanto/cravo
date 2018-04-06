package org.academiadecodigo.hackathon.cravo.services;

import java.util.HashMap;
import java.util.Map;

public class OrderService implements Service{

    private Map<String, Integer> order = new HashMap<>();

    public void putOrder(String string){
        order.put(string, 1);
    }

    public Map<String, Integer> getOrders() {
        return order;
    }
}
