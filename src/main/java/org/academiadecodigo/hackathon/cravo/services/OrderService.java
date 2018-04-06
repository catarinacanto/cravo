package org.academiadecodigo.hackathon.cravo.services;

import java.util.HashMap;
import java.util.Map;

public class OrderService implements Service{

    private Map<String, Integer> order = new HashMap<>();

    public void putOrder(String string, Integer amount){
        order.put(string, amount);
    }

    public Map<String, Integer> getOrders() {
        return order;
    }

    public void emptyMap(){
        if (!order.isEmpty()){
            order.clear();
        }

    }
}
