package com.example.nicecoding.fleet.model;

import com.example.nicecoding.hr.model.Employee;
import com.example.nicecoding.parameter.model.Location;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Vehicle")
public class Vehicle {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	private String name;
	
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;

	private String description;
	private String power;
	private short fuelCapacity;
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false )
	private Employee inCharge;
	private Integer employeeid;

	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Integer locationid;
}
