package com.mutipolar.bootcamp.kyc.repository;

import com.mutipolar.bootcamp.kyc.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustRepository extends MongoRepository<Customer, String> {
}
