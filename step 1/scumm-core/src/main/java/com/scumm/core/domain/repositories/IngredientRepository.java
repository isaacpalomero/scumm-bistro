package com.scumm.core.domain.repositories;

import com.scumm.core.domain.entities.Ingredient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, ObjectId> {
}
