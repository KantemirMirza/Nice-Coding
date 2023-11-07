package com.example.nicecoding.hr.repository;

import com.example.nicecoding.hr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//public Employee findByUsername(String un);

//	@Query(value = "select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%",
//			nativeQuery = true)
//    List<Employee> findByKeyword(@Param("keyword") String keyword);
//
//	@Query(value = "SELECT city, count(*) FROM Employee GROUP BY city",
//			nativeQuery = true)
//	List<Object> getCountByCountry();
}
