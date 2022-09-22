package com.codeclan.examples.coursebookingservice.repositories;

import com.codeclan.examples.coursebookingservice.models.Booking;
import com.codeclan.examples.coursebookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDate(LocalDate date);

}
