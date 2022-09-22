package com.codeclan.examples.coursebookingservice.controllers;

import com.codeclan.examples.coursebookingservice.models.Booking;
import com.codeclan.examples.coursebookingservice.models.Course;
import com.codeclan.examples.coursebookingservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings/date")
    public ResponseEntity<List<Booking>> getCoursesByCustomer(@RequestParam(name="year") int year, @RequestParam(name="month") int month, @RequestParam(name="day") int day){
        LocalDate date = LocalDate.of(year, month, day);
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }
}
