package com.suvigya.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suvigya.entity.ClassEntity;
import com.suvigya.repository.ClassRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Transactional
    public List<ClassEntity> createClass(String name, LocalDate startDate, LocalDate endDate, LocalTime startTime, int duration, int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after the start date.");
        }
        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Start date must be in the future.");
        }

        List<ClassEntity> classes = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setName(name);
            classEntity.setStartDate(currentDate);
            classEntity.setEndDate(endDate);
            classEntity.setStartTime(startTime);
            classEntity.setDuration(duration);
            classEntity.setCapacity(capacity);

            classes.add(classEntity);
            currentDate = currentDate.plusDays(1);
        }

        return classRepository.saveAll(classes);
    }

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }
}

