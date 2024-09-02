package com.workintech.s18d2.util;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.services.FruitService;
import org.springframework.http.HttpStatus;

public class FruitValidation {

    public static boolean doesExist(FruitService fruitService, Fruit fruit){
        if(fruitService.getById(fruit.getId()) == null){
            return false;
        } else {
            return true;
        }
    }

    public static void isIdValid(Long id) {
        if(id == null || id < 0 ){
            throw new FruitException("Id is not valid", HttpStatus.BAD_REQUEST);
        }
    }
}
