package com.codeclan.examples.coursebookingservice.controllers;

import com.codeclan.examples.coursebookingservice.models.Course;
import com.codeclan.examples.coursebookingservice.models.Customer;
import com.codeclan.examples.coursebookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers/course")
    public ResponseEntity<List<Customer>> getCustomersByCourse(@RequestParam(name="course") String course){
        return new ResponseEntity<>(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/town/course")
    public ResponseEntity<List<Customer>> getCustomersByTownAndCourse(@RequestParam(name="town") String town, @RequestParam(name="name")String name){
        return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, name), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/town/course/age")
    public ResponseEntity<List<Customer>> getCustomersByTownAndCourseAndAge(@RequestParam(name="town") String town, @RequestParam(name="name")String name, @RequestParam(name="age")int age){
        return new ResponseEntity<>(customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(town, name, age), HttpStatus.OK);
    }



}
