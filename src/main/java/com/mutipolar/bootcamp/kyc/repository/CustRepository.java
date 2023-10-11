package com.mutipolar.bootcamp.kyc.repository;

import com.mutipolar.bootcamp.kyc.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByNik(String nik);
    @Query("{ 'nik' : { $regex: '34826226646462900', $options: 'i' } }")
    Optional<Customer> findByNikCaseInsensitive(String nik);

    @Query("{ 'firstName' : { $regex: ?0, $options: 'i' } }")
    List<Customer> findByFistName(String firstName);
}
