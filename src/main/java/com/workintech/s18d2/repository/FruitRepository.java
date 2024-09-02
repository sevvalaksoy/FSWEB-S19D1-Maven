package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query("SELECT f FROM Fruit f ORDER BY price")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f ORDER BY price DESC")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);
}
