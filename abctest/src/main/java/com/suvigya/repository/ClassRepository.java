package com.suvigya.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suvigya.entity.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
