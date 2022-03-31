package com.shrey.springdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name= "tbl_course_material")
@Data

@AllArgsConstructor
@ToString(exclude = "course")
public class CourseMaterial {
	@Id
	@SequenceGenerator(name = "course_material_sequence",
	sequenceName = "course_material_sequence",
	allocationSize = 1,
	initialValue = 3000001)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
	generator = "course_material_sequence")
	private Long courseMaterialId;
	private String courseUrl;
	@OneToOne
	@JoinColumn(name = "course_id",
	referencedColumnName = "courseId")
	private Course course;
	

	public CourseMaterial() {
		
	}

	public CourseMaterial(String courseUrl, Course course) {
		super();
		this.courseUrl = courseUrl;
		this.course = course;
	}
	public CourseMaterial(String courseUrl) {
		super();
		this.courseUrl = courseUrl;

	}
	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", courseUrl=" + courseUrl + "]";
	}
	
	

}
