package com.suvigya.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suvigya.entity.BookingEntity;
import com.suvigya.entity.ClassEntity;
import com.suvigya.repository.BookingRepository;
import com.suvigya.repository.ClassRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final ClassRepository classRepository;

    public BookingService(BookingRepository bookingRepository, ClassRepository classRepository) {
        this.bookingRepository = bookingRepository;
        this.classRepository = classRepository;
    }

    @Transactional
    public BookingEntity createBooking(String memberName, Long classId, LocalDate participationDate,LocalTime startTime) {
        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new IllegalArgumentException("Class not found."));

        if (participationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Participation date must be in the future.");
        }

        if (!classEntity.getStartDate().equals(participationDate)) {
            throw new IllegalArgumentException("Participation date does not match the class date.");
        }

        long currentBookings = bookingRepository.countByClassEntityAndParticipationDate(classEntity, participationDate);
        if (currentBookings >= classEntity.getCapacity()) {
            throw new IllegalArgumentException("Class capacity exceeded for the selected date.");
        }

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setMemberName(memberName);
        bookingEntity.setClassEntity(classEntity);
        bookingEntity.setParticipationDate(participationDate);
        bookingEntity.setClassStartTime(startTime);

        return bookingRepository.save(bookingEntity);
    }

    public List<BookingEntity> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        if (memberName != null && startDate != null && endDate != null) {
            return bookingRepository.findByMemberNameAndParticipationDateBetween(memberName, startDate, endDate);
        } else if (memberName != null) {
            return bookingRepository.findByMemberName(memberName);
        } else if (startDate != null && endDate != null) {
            return bookingRepository.findByParticipationDateBetween(startDate, endDate);
        } else {
            throw new IllegalArgumentException("At least one search parameter is required.");
        }
    }

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }
}

