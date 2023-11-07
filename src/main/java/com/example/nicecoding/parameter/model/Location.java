package com.example.nicecoding.parameter.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Location")
public class Location {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;

		@Column(nullable = false)
		private String description;

		private String details;

		@ManyToOne
		@JoinColumn(name = "countryid", referencedColumnName = "id", insertable = false, updatable = false)
		private Country country;

		@Column(name = "countryid")
		private Integer countryId;

		@ManyToOne
		@JoinColumn(name = "stateid", referencedColumnName = "id", insertable = false, updatable = false)
		private State state;

		@Column(name = "stateid")
		private Integer stateId;

		private String city;
		private String address;



//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private Integer id;
//
//	@Column(nullable = false)
//	private String description;
//	private String details;
//
//	@ManyToOne
//	@JoinColumn(name="countryid", insertable=false, updatable=false)
//	private Country country;
//	private Integer countryid;
//
//	@ManyToOne
//	@JoinColumn(name="stateid", insertable=false, updatable=false)
//	private State state;
//	private Integer stateid;
//
//	private String city;
//	private String address;
}
