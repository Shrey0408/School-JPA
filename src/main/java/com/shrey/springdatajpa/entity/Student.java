package com.shrey.springdatajpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	
	
	@Id
	@SequenceGenerator(name = "student_sequence",
	sequenceName = "student_sequence",
	allocationSize = 1,
	initialValue = 1000001)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,
	generator = "student_sequence")
	private long id ;
	private String firstName;
	private String lastName;
	@Column(name="email_address",
			nullable = false)
	private String email;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "name",
		column = @Column(name = "guardian_name")),
		@AttributeOverride(name = "email",
		column = @Column(name = "guardian_email")),
		@AttributeOverride(name = "mobile",
		column = @Column(name = "guardian_mobile"))	
		
	})
	public Guardian guardian;
	
	public Student(String firstName, String lastName, String email, Guardian guardian) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.guardian = guardian;
	}
		
}
