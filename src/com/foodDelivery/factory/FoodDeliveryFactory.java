package com.foodDelivery.factory;

import com.foodDelivery.repository.FoodDeliveryRepository;
import com.foodDelivery.service.FoodDeliveryService;
import com.foodDelivery.controller.FoodDeliveryController;

//Factory loo manaku ae object kavalo aa object ni create chesi return chesthundi. 
//Factory responsibility is to provide objects. 
public class FoodDeliveryFactory {
    public static FoodDeliveryController getController() {
    return FoodDeliveryController.getInstance();
}

    public static FoodDeliveryService getService() {
        return FoodDeliveryService.getInstance();
    }

    public static FoodDeliveryRepository getRepository() {
        return FoodDeliveryRepository.getInstance();
    }
}