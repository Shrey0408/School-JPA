package com.shrey.springdatajpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teacher")
public class Teacher {
	@Id
	@SequenceGenerator(name = "teacher_sequence"
	,sequenceName = "teacher_sequence"
	,initialValue = 4000001,
	allocationSize = 1)
	@GeneratedValue(generator = "teacher_sequence"
	,strategy = GenerationType.SEQUENCE)
	private Long teacherId;
	private String firstName;
	private String lastName;
//	
//	@OneToMany(cascade = CascadeType.MERGE)
//	
//	@JoinColumn(name = "teacher_id"
//	,referencedColumnName = "teacherId")
//	
//	private List<Course> courses;
	public Teacher() {
		
	}
	public Teacher(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
