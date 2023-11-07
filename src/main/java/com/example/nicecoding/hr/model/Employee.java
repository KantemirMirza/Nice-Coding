package com.example.nicecoding.hr.model;

import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.model.State;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String socialSecurityNumber;
	private String firstname;
	private String lastname;
	private String middleName;
	private String gender;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Integer countryid;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth; // BIRTH DATE
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;
	private Integer stateid;

	private String city; // CITY
	private String phone; // PHONE
	private String maritalStatus;
	private String email; // E-MAIL
	private String photo; // USERNAME

//	@Formula(value = " concat(firstname, ' ', lastname) ")
//	private String fullName; // FULL NAME
}
