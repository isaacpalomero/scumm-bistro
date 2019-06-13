package com.scumm.core.domain.repositories;

import com.scumm.core.domain.entities.Category;
import com.scumm.core.domain.entities.Dish;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends MongoRepository<Dish, ObjectId> {
}
