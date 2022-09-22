package com.codeclan.examples.coursebookingservice.repositories;

import com.codeclan.examples.coursebookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByBookingsCustomerNameIgnoreCase(String name);
    List<Course> findByRating(int rating);


}
