package com.mutipolar.bootcamp.kyc.repository;

import com.mutipolar.bootcamp.kyc.domain.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
