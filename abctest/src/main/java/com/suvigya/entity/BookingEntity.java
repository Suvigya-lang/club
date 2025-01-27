package com.suvigya.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bookings", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"class_id", "participation_date", "member_name"}))
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    @JsonIgnore
    private ClassEntity classEntity;

    @Column(name = "participation_date", nullable = false)
    private LocalDate participationDate;

    @Column(name = "class_start_time", nullable = false)
    private LocalTime classStartTime;

    // Default constructor (required for JPA)
    public BookingEntity() {}

    // Constructor with fields
    public BookingEntity(String memberName, ClassEntity classEntity, LocalDate participationDate, LocalTime classStartTime) {
        this.memberName = memberName;
        this.classEntity = classEntity;
        this.participationDate = participationDate;
        this.classStartTime = classStartTime;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
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

