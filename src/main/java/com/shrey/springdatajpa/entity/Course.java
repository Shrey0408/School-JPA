package com.shrey.springdatajpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
	@Id
	@SequenceGenerator(name = "course_sequence",
	sequenceName = "course_sequence",
	allocationSize = 1,
	initialValue = 2000001)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
	generator = "course_sequence")
	private Long courseId;
	private String title;
	private Integer credit;
	@OneToOne(
			cascade = CascadeType.ALL
			,mappedBy = "course")
	private CourseMaterial courseMaterial;
	public Course() {
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id"
	, referencedColumnName = "teacherId")
	private Teacher teacher; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "course_student_mapping"
			, joinColumns = @JoinColumn(name = "course_id"
			, referencedColumnName = "courseId")
			,inverseJoinColumns = @JoinColumn(name = "student_id"
			,referencedColumnName = "id")
			)
	List<Student> students;
	public Course(String title, Integer credit) {
		super();
		this.title = title;
		this.credit = credit;
	}
	public Course(String title, Integer credit,CourseMaterial courseMaterial,Teacher teacher) {
		super();
		this.title = title;
		this.credit = credit;
		this.courseMaterial = courseMaterial;
		this.teacher = teacher;
	}
	
	public void addStudents(Student student) {
		if(this.students == null) {
			this.students = new ArrayList<Student>();
		}
		this.students.add(student);
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", credit=" + credit + ", courseMaterial="
				+ courseMaterial + "]";
	}
	
	
}
