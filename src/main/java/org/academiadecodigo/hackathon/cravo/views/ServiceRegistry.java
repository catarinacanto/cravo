package org.academiadecodigo.hackathon.cravo.views;

import org.academiadecodigo.hackathon.cravo.services.CRUDService;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {


    static Map<String, CRUDService> serviceMap;

    public ServiceRegistry() {
        serviceMap = new HashMap<>();
    }


    public static void addService(String serviceName, CRUDService service) {

        serviceMap.put(serviceName, service);
    }

    public static CRUDService getService(String serviceName){

        return serviceMap.get(serviceName);
    }
}
