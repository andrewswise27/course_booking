package com.codeclan.examples.coursebookingservice.repositories;

import com.codeclan.examples.coursebookingservice.models.Course;
import com.codeclan.examples.coursebookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCaseAndAgeGreaterThan(String town, String name, int age);

}
