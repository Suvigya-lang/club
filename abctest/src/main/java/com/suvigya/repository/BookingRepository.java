package com.suvigya.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suvigya.entity.BookingEntity;
import com.suvigya.entity.ClassEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByMemberName(String memberName);
    List<BookingEntity> findByParticipationDateBetween(LocalDate startDate, LocalDate endDate);
    List<BookingEntity> findByMemberNameAndParticipationDateBetween(String memberName, LocalDate startDate, LocalDate endDate);
    long countByClassEntityAndParticipationDate(ClassEntity classEntity, LocalDate participationDate);

}

