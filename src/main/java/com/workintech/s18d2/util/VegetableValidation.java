package com.workintech.s18d2.util;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.VegetableException;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.http.HttpStatus;

public class VegetableValidation {

    public static boolean doesExist(VegetableService vegetableService, Vegetable vegetable){
        if(vegetableService.getById(vegetable.getId()) == null){
            return false;
        } else {
            return true;
        }
    }
    public static void isIdValid(Long id) {
        if(id == null || id < 0 ){
            throw new VegetableException("Id is not valid", HttpStatus.BAD_REQUEST);
        }
    }
}
