package com.shrey.springdatajpa.configuration;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.shrey.springdatajpa.entity.Course;
import com.shrey.springdatajpa.entity.CourseMaterial;
import com.shrey.springdatajpa.entity.Guardian;
import com.shrey.springdatajpa.entity.Student;
import com.shrey.springdatajpa.entity.Teacher;
import com.shrey.springdatajpa.repository.CourseMaterialRepository;
import com.shrey.springdatajpa.repository.CourseRepository;
import com.shrey.springdatajpa.repository.TeacherRepository;
import com.shrey.springdatajpa.repository.studentRepository;

@Configuration
public class studentConfiguration {
	@Bean
	@Order
	CommandLineRunner commandLineRunner(studentRepository studentRepository) {
		CommandLineRunner clr = args -> {
			Student asas = new Student("Asas", "Dao", "XYZ@hmail.com",
					new Guardian("Kim", "kim@dmail.com", "910889090"));

			Student asad = new Student("Asad", "Daow", "XYdZ@hmail.com",
					new Guardian("jing", "Jing@dmail.com", "91081389090"));

			studentRepository.save(asas);
			studentRepository.save(asad);
		};
		return clr;
	}
//	@Bean
//	@Order(1)
//	CommandLineRunner commandLineRunner2(studentRepository studentRepository) {
//		CommandLineRunner clr = args -> {
//			List<Student> studList = studentRepository.findAll();
//			System.out.println(studList);
//		};
//		return clr;
//	}
//	@Bean
//	@Order(1)
//	CommandLineRunner commandLineRunner3(studentRepository studentRepository) {
//		CommandLineRunner clr = args -> {
//			List<Student> stud = studentRepository.findByFirstNameStartingWith("As");
//			System.out.println(stud);
//		};
//		return clr;
//	}
//
//	@Bean
//	@Order(1)
//	CommandLineRunner commandLineRunner3(studentRepository studentRepository) {
//		CommandLineRunner clr = args -> {
//			Student stud = studentRepository.getStudentByEmailAddress("XYZ@hmail.com");
//			System.out.println(stud);
//		};
//		return clr;
//	}
//
//	@Bean
//	CommandLineRunner commandLineRunner4(studentRepository studentRepository) {
//		CommandLineRunner clr = args -> {
//			int rows = studentRepository.updateStudentEmailIdByEmailId("XYZ@hmail.com", "abc@ymail.com");
//			System.out.println("Rows Affected" + rows);
//		};
//		return clr;
//	}
//	@Bean
//	@Order(1)
//	CommandLineRunner commandLineRunner5(CourseMaterialRepository courseMaterialRepository) {
//		CommandLineRunner clr = args -> {
//			Course dsa = new Course("DSA",7);
//			
//			CourseMaterial dsaMaterial = new CourseMaterial("www.dsa.com",dsa);
//			
//			courseMaterialRepository.save(dsaMaterial);
//			
//		};
//		return clr;
//	}
//	@Bean
//	@Order(232323)
//
//	CommandLineRunner commandLineRunner6(CourseMaterialRepository courseMaterialRepository) {
//		CommandLineRunner clr = args -> {
//			List<CourseMaterial> list = courseMaterialRepository.findAll();
//			System.out.println(list);
//		};
//		return clr;
//	}
//	@Order(232323)

//	CommandLineRunner commandLineRunner7(CourseRepository courseRepository) {
//		CommandLineRunner clr = args -> {
//			List<Course> list = courseRepository.findAll();
//			System.out.println(list);
//		};
//		return clr;
//	}
//	@Order
//	@Bean
//	CommandLineRunner commandLineRunner9(TeacherRepository teacherRepository,CourseMaterialRepository courseMaterialRepository) {
//		CommandLineRunner clr = args -> {
//			Course dba = new Course("DBA",3);
//			Course os = new Course("OS",4);
//			Course dsa = new Course("DSA",7);
//			CourseMaterial dbaMaterial = new CourseMaterial("www.dba.com", dba);
//			CourseMaterial osMaterial = new CourseMaterial("www.os.com", os);
//			CourseMaterial dsaMaterial = new CourseMaterial("www.dsa.com",dsa);
//			courseMaterialRepository.saveAll(List.of(dbaMaterial,osMaterial,dsaMaterial));
//			
//			Teacher raj = new Teacher("Rajesh", "Khan", List.of(dba,os,dsa));
//			teacherRepository.save(raj);
//			
//		};
//		return clr;
//	}
//	@Bean
//	CommandLineRunner commandLineRunner8(TeacherRepository teacherRepository) {
//		CommandLineRunner clr = args -> {
//			List<Teacher> list = teacherRepository.findAll();
//			System.out.println(list);
//		};
//		return clr;
//	}
	@Bean
	CommandLineRunner commandLineRunner9(CourseRepository courseRepsoitory) {
		CommandLineRunner clr = args -> {
			
			CourseMaterial dbaMaterial = new CourseMaterial("www.dba.com");
			CourseMaterial osMaterial = new CourseMaterial("www.os.com");
			CourseMaterial dsaMaterial = new CourseMaterial("www.dsa.com");
			Teacher raj = new Teacher("Rajesh", "Khan");
			
			Course dba = new Course("DBA",3,dbaMaterial,raj);
			Course os = new Course("OS",4,osMaterial,raj );
			Course dsa = new Course("DSA",7,dsaMaterial,raj);
			
			courseRepsoitory.saveAll(List.of(dba,os,dsa));
			
		
			
		};
		return clr;
	}
//	@Bean
//	CommandLineRunner commandLineRunner10(CourseRepository courseRepsoitory) {
//		CommandLineRunner clr = args -> {
//			
//			Pageable firstPage = PageRequest.of(0, 2); 
//			Pageable secondPage = PageRequest.of(1, 2); 
//			
//			List<Course> firstPageCourses =  courseRepsoitory.findAll(firstPage).getContent();
//			List<Course> secondPageCourses =  courseRepsoitory.findAll(secondPage).getContent();
//			System.out.println("First Pg"+firstPageCourses);
//			System.out.println("Second Pg"+firstPageCourses);
//			
//		
//			
//		};
//		return clr;
//	}
//	@Bean
//	CommandLineRunner commandLineRunner10(CourseRepository courseRepsoitory) {
//		CommandLineRunner clr = args -> {
//			
//			Pageable firstPage = PageRequest.of(0, 2, Sort.by("title")); 
//			Pageable secondPage = PageRequest.of(0, 4, Sort.by("credit").descending()); 
//			Pageable sortByCreditAndTitle = PageRequest.of(0, 4, Sort.by("credit").descending().and(Sort.by("title"))); 
//			List<Course> firstPageCoursesSortByTitle =  courseRepsoitory.findAll(firstPage).getContent();
//			List<Course> secondPageCoursesSortByCredit =  courseRepsoitory.findAll(secondPage).getContent();
//			List<Course> sortByCreditAndTitleCourses =  courseRepsoitory.findAll(secondPage).getContent();
//			
//			List<Course> customMethod = courseRepsoitory.findByTitleContaining("D",sortByCreditAndTitle).getContent();
//			System.out.println("First Pg"+customMethod);
//		};
//		return clr;
//	}
	
	@Bean
	CommandLineRunner commandLineRunner15(CourseRepository courseRepsoitory) {
		CommandLineRunner clr = args -> {
			
			CourseMaterial dbaMaterial = new CourseMaterial("www.dba.com");
			//CourseMaterial osMaterial = new CourseMaterial("www.os.com");
			//CourseMaterial dsaMaterial = new CourseMaterial("www.dsa.com");
			Teacher ramanjesh = new Teacher("Raman", "Khanna");
			
			Course dba = new Course("ML",3,dbaMaterial,ramanjesh);
			//Course os = new Course("OS",4,osMaterial,ram );
			//Course dsa = new Course("DSA",7,dsaMaterial,raj);
			dba.addStudents(new Student("ran", "down", "run@walk.com", new Guardian("Jump","jump@ren.com","72387")));
			courseRepsoitory.saveAll(List.of(dba));
			
		
			
		};
		return clr;
	}
}
