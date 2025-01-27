package com.suvigya.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDto {

    private String memberName;
    private Long classId;  // classId to link to ClassEntity
    private LocalDate participationDate;
    private LocalTime classStartTime;

    // Default constructor
    public BookingDto() {}

    // Constructor with fields
    public BookingDto(String memberName, Long classId, LocalDate participationDate, LocalTime classStartTime) {
        this.memberName = memberName;
        this.classId = classId;
        this.participationDate = participationDate;
        this.classStartTime = classStartTime;
    }

    // Getters and setters
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public LocalDate getParticipationDate() {
        return participationDate;
    }

    public void setParticipationDate(LocalDate participationDate) {
        this.participationDate = participationDate;
    }

    public LocalTime getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(LocalTime classStartTime) {
        this.classStartTime = classStartTime;
    }
}

