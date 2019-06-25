package com.scumm.micros.dish.creator.domain.repositories;

import com.scumm.micros.dish.creator.domain.entities.Dish;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends MongoRepository<Dish, ObjectId> {
}
