package com.scumm.micros.category.sync.domain.repositories;

import com.scumm.micros.category.sync.domain.entities.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
}
