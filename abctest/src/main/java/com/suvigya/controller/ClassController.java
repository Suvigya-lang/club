package com.suvigya.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.suvigya.entity.ClassEntity;
import com.suvigya.service.ClassService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }


     @PostMapping
    public ResponseEntity<List<ClassEntity>> createClass(@RequestBody ClassEntity classRequest) {
        // Retrieve all fields from the request body and store them in variables
        String name = classRequest.getName();
        LocalDate startDate = classRequest.getStartDate();
        LocalDate endDate = classRequest.getEndDate();
        LocalTime startTime = classRequest.getStartTime();
        int duration = classRequest.getDuration();
        int capacity = classRequest.getCapacity();

        // Make the request to the service layer
        List<ClassEntity> createdClasses = classService.createClass(name, startDate, endDate, startTime, duration, capacity);

        // Return the created classes
        return new ResponseEntity<>(createdClasses, HttpStatus.CREATED);
    }

    /**
     * Retrieve all classes.
     */
    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        List<ClassEntity> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }
}

