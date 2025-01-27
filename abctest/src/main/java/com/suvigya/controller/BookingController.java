package com.suvigya.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.suvigya.dto.BookingDto;
import com.suvigya.dto.SearchRequest;
import com.suvigya.entity.BookingEntity;
import com.suvigya.service.BookingService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Create a booking for a member.
     */
    @PostMapping
    public ResponseEntity<BookingEntity> createBooking(@RequestBody BookingDto bookingRequest) {
    	String memberName = bookingRequest.getMemberName();
        Long classId = bookingRequest.getClassId();
        LocalDate participationDate = bookingRequest.getParticipationDate();
        LocalTime classStartTime = bookingRequest.getClassStartTime();


        BookingEntity bookingResponse = bookingService.createBooking(memberName, classId, participationDate,classStartTime);
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }

    /**
     * Search bookings by member name, date range, or both.
     */
    @PostMapping("search")
    public ResponseEntity<List<BookingEntity>> searchBookings(@RequestBody SearchRequest searchRequest) {
        // Extract search parameters from DTO
        String memberName = searchRequest.getMemberName();
        LocalDate startDate = searchRequest.getStartDate();
        LocalDate endDate = searchRequest.getEndDate();

        // Call the service with extracted parameters
        List<BookingEntity> bookings = bookingService.searchBookings(memberName, startDate, endDate);
        return ResponseEntity.ok(bookings);
    }

    /**
     * Retrieve all bookings.
     */
    @GetMapping
    public ResponseEntity<List<BookingEntity>> getAllBookings() {
        List<BookingEntity> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
