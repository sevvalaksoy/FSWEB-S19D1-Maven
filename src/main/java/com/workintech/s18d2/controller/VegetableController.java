package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import com.workintech.s18d2.util.VegetableValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAll(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getFruit(@PathVariable Long id){
        VegetableValidation.isIdValid(id);
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable update(Vegetable vegetable){
        if(VegetableValidation.doesExist(vegetableService,vegetable)){
            vegetableService.update(vegetable);
        } else vegetableService.save(vegetable);
        return vegetable;
    }

    @PostMapping("/{name}")
    public List<Vegetable> getAll(@PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        VegetableValidation.isIdValid(id);
        return vegetableService.delete(id);
    }
}
