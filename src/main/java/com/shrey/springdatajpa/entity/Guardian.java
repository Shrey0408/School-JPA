package com.shrey.springdatajpa.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable

public class Guardian {
	private String name;
	private String email;
	private String mobile;
	
	public Guardian() {
		super();
	}

	public Guardian(String name, String email, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
}
