package com.example.aluminidashboardP.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sId")
	private Integer id;
	@Column(name="sName" ,length=30)
	private String name;
	@Column(name="sPhoneNo" ,length=10)
	private String phone;
	@Column(name="sEmail" ,length=30)
	private String email;
	@Column(name="sGraduationYear" ,length=10)
	private String grdYear;
	public Student(String name, String phone, String email, String grdYear) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.grdYear = grdYear;
	}
}
