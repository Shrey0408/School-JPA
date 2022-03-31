package com.shrey.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shrey.springdatajpa.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
