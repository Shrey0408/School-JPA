package com.shrey.springdatajpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shrey.springdatajpa.entity.Student;

public interface studentRepository extends JpaRepository<Student, Long>{
	public Student findByFirstName(String firstName);
	public List<Student> findByFirstNameStartingWith(String firstNameLike);
	public Student findByGuardianName(String gName);
//	@Query("select s from Student s where s.email = ?1")
//	public Student getStudentByEmailAddress(String emailId);
//	@Query(value = "select * from tbl_student t where email_address = ?1",
//			nativeQuery = true)
//	public Student getStudentByEmailAddress(String emailId);
	@Query(value = "select * from tbl_student t where email_address = :email ",
			nativeQuery = true)
	public Student getStudentByEmailAddress(@Param("email") String emailId);
	
	@Modifying(flushAutomatically = true)
	@Transactional
	@Query(value = "update tbl_student set email_address=:newEmail where email_address = :oldEmail ",
			nativeQuery = true)
	public int updateStudentEmailIdByEmailId(@Param("oldEmail") String oldEmail,@Param("newEmail") String newEmail);
}
