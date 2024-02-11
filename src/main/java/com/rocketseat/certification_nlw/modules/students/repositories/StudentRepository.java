package com.rocketseat.certification_nlw.modules.students.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocketseat.certification_nlw.modules.students.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    // there's no need any query here because "email" belongs to StudentEntity yet
    // Optional => allow return just whether exist something
    public Optional<StudentEntity> findByEmail(String email);
}
