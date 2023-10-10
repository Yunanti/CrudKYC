package com.mutipolar.bootcamp.kyc.controller;

import com.mutipolar.bootcamp.kyc.domain.Customer;
import com.mutipolar.bootcamp.kyc.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kyc")
//@Validated
public class CustController {
    private final CustService custService;

    @Autowired
    public CustController(CustService custService) {
        this.custService = custService;
    }


    @PostMapping
    public Customer createTodo(@RequestBody Customer customer){
        return custService.createOrUpdateCust(customer);
    }
//    public ResponseEntity<?> createTodo(@Valid @RequestBody Todo todo,
//                                        BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            List<ErrorMessage> validationErrors = new ArrayList<>();
//            for (FieldError error : bindingResult.getFieldErrors()) {
//                ErrorMessage errorMessage = new ErrorMessage();
//                errorMessage.setCode("VALIDATION_ERROR");
//                errorMessage.setMessage(error.getDefaultMessage());
//                validationErrors.add(errorMessage);
//            }
//            return ResponseEntity.badRequest().body(validationErrors);
//        }
//        Todo createdTodo = todoService.createOrUpdateTodo(todo);
//        return ResponseEntity.ok(createdTodo);
//    }

    @GetMapping
    public List<Customer> getAllCusts(){
        return custService.getAllCusts();
    }

    //    get todo by id lewat pathvariable/segment
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getTodoById(@PathVariable String id){
        Optional<Customer> todo = custService.getCustById((id));
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //    edit todo by id
    @PutMapping("/{id}")
    public Customer updateCust(@PathVariable String id, @RequestBody Customer customer){
        customer.setId(id);
        return custService.createOrUpdateCust(customer);
    }

    //    delete todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustId(@PathVariable String id){
        custService.deleteCustById(id);
        return ResponseEntity.noContent().build();
    }
}
