package com.mutipolar.bootcamp.kyc.service;

import com.mutipolar.bootcamp.kyc.domain.Customer;
import com.mutipolar.bootcamp.kyc.repository.CustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustService {
    private final CustRepository custRepository;

    @Autowired
    public CustService(CustRepository custRepository) {
        this.custRepository = custRepository;
    }

    //    fungsi untuk get all todos
    public List<Customer> getAllCusts(){ // untuk mendapatkan data dari repository
        return custRepository.findAll();
    }

    //    fungsi untuk get todo by id
    public Optional<Customer> getCustById(String id){
        return custRepository.findById(id);
    }

    //    fungsi untuk create or update todo
    public Customer createOrUpdateCust(Customer customer){
        return custRepository.save(customer);
    }

    //    fungsi untuk menghapus todo
    public void deleteCustById(String id){
        custRepository.deleteById(id);
    }
}
