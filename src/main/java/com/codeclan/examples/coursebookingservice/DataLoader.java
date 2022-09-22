package com.codeclan.examples.coursebookingservice;

import com.codeclan.examples.coursebookingservice.models.Booking;
import com.codeclan.examples.coursebookingservice.models.Course;
import com.codeclan.examples.coursebookingservice.models.Customer;
import com.codeclan.examples.coursebookingservice.repositories.BookingRepository;
import com.codeclan.examples.coursebookingservice.repositories.CourseRepository;
import com.codeclan.examples.coursebookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    BookingRepository bookingRepo;
    @Autowired
    CourseRepository courseRepo;

    public DataLoader(){};

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = new Customer("James", "Edinburgh", 23);
        Customer customer2 = new Customer("Andrew", "Edinburgh", 27);
        Customer customer3 = new Customer("Chris", "Fife", 25);
        Customer customer4 = new Customer("Naefun", "Lakes", 30);
        Customer customer5 = new Customer("Keith", "CodeClan", 18);
        Customer customer6 = new Customer("Mar", "Campbelltown", 26);
        customerRepo.save(customer);
        customerRepo.save(customer2);
        customerRepo.save(customer3);
        customerRepo.save(customer4);
        customerRepo.save(customer5);
        customerRepo.save(customer6);
        Course course = new Course("Intro to Python", "Edinburgh", 4);
        Course course2 = new Course("Intro to Java", "Edinburgh", 4);
        Course course3 = new Course("Intro to JavaScript", "Edinburgh", 1);
        Course course4 = new Course("Intro to Spring", "Edinburgh", 4);
        Course course5 = new Course("Intro to Flask", "Edinburgh", 4);
        Course course6 = new Course("Extreme Python", "Edinburgh", 5);
        courseRepo.save(course);
        courseRepo.save(course2);
        courseRepo.save(course3);
        courseRepo.save(course4);
        courseRepo.save(course5);
        courseRepo.save(course6);
        LocalDate date = LocalDate.of(2022, 12, 25);
        LocalDate date2 = LocalDate.of(2022, 1, 14);
        LocalDate date3 = LocalDate.of(2022, 2, 13);
        LocalDate date4 = LocalDate.of(2022, 3, 10);
        LocalDate date5 = LocalDate.of(2022, 4, 12);
        LocalDate date6 = LocalDate.of(2022, 5, 27);
        Booking booking = new Booking(date, customer, course);
        Booking booking2 = new Booking(date2, customer2, course2);
        Booking booking3 = new Booking(date3, customer3, course3);
        Booking booking4 = new Booking(date4, customer4, course4);
        Booking booking5 = new Booking(date5, customer5, course5);
        Booking booking6 = new Booking(date6, customer6, course6);
        Booking booking7 = new Booking(date, customer, course6);
        bookingRepo.save(booking);
        bookingRepo.save(booking2);
        bookingRepo.save(booking3);
        bookingRepo.save(booking4);
        bookingRepo.save(booking5);
        bookingRepo.save(booking6);
        bookingRepo.save(booking7);
    }
}
