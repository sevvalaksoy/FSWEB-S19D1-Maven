package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit save(Fruit fruit);
    Fruit update(Fruit fruit);
    Fruit delete(Long id);
    Fruit getById(Long id);
    List<Fruit> findAll();
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    List<Fruit> searchByName(String name);
}
