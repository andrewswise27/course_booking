package com.codeclan.examples.coursebookingservice.controllers;

import com.codeclan.examples.coursebookingservice.models.Booking;
import com.codeclan.examples.coursebookingservice.models.Course;
import com.codeclan.examples.coursebookingservice.models.Customer;
import com.codeclan.examples.coursebookingservice.repositories.BookingRepository;
import com.codeclan.examples.coursebookingservice.repositories.CourseRepository;
import com.codeclan.examples.coursebookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/courses/rating")
    public ResponseEntity<List<Course>> getCoursesByRating(@RequestParam(name="rating") int rating){
        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/customer")
    public ResponseEntity<List<Course>> getCoursesByCustomer(@RequestParam(name="customer") String customer){
        return new ResponseEntity<>(courseRepository.findByBookingsCustomerNameIgnoreCase(customer), HttpStatus.OK);
    }


}
