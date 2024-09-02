package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.util.FruitValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAll(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getFruit(@PathVariable Long id){
        FruitValidation.isIdValid(id);
        return fruitService.getById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getAllDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        fruitService.save(fruit);
        return fruit;
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getAll(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        Fruit fruit = fruitService.getById(id);
        fruitService.delete(id);
        return fruit;
    }

}
