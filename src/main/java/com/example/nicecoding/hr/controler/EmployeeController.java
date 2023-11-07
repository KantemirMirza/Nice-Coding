package com.example.nicecoding.hr.controler;

import com.example.nicecoding.hr.model.Employee;
import com.example.nicecoding.hr.service.EmployeeService;
import com.example.nicecoding.parameter.model.Country;
import com.example.nicecoding.parameter.model.State;
import com.example.nicecoding.parameter.service.CountryService;
import com.example.nicecoding.parameter.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	private final StateService stateService;
	private final CountryService countryService;


	@GetMapping("/employees")
	public String listOfEmployee(Model model){
		List<Employee> employee = employeeService.listOfEmployee();
		model.addAttribute("listOfEmployee", employee);
		return"hr/employee/listOfEmployee";
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model){
		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		return"hr/employee/addEmployee";
	}

	@PostMapping("/addEmployee")
	public String saveEmployee(@ModelAttribute Employee employee){
		employeeService.saveEmployee(employee);
		return"redirect:/employees";
	}

	@GetMapping("/employees/{id}/edit")
	public String editEmployee(@PathVariable Integer id, Model model) {
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("employee", employee);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		return "hr/employee/editEmployee";
	}

	@PostMapping("/employees/{id}/edit")
	public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee") Employee employee) {
		Employee emp = employeeService.findEmployeeById(id);
		emp.setFirstname(employee.getFirstname());
		emp.setLastname(employee.getLastname());
		emp.setMiddleName(employee.getMiddleName());
		emp.setSocialSecurityNumber(employee.getSocialSecurityNumber());
		emp.setGender(employee.getGender());
		emp.setMaritalStatus(employee.getMaritalStatus());
		emp.setCountry(employee.getCountry());
		emp.setState(employee.getState());
		emp.setDateOfBirth(employee.getDateOfBirth());
		emp.setCity(employee.getCity());
		emp.setPhone(employee.getPhone());
		emp.setEmail(employee.getEmail());
		emp.setPhoto(employee.getPhoto());
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}/delete")
	public String deleteEmployee(@PathVariable Integer id){
		Employee employee = employeeService.findEmployeeById(id);
		employeeService.deleteEmployee(employee);
		return"redirect:/employees";
	}

	@GetMapping("/employees/{id}/info")
	public String infoEmployee(Model model, @PathVariable Integer id){
		Employee employee = employeeService.findEmployeeById(id);
		model.addAttribute("infoEmployee", employee);

		List<Country> countries = countryService.listOfCountry();
		model.addAttribute("listOfCountry", countries);

		List<State> states = stateService.listOfState();
		model.addAttribute("listOfState", states);
		return"hr/employee/infoEmployee";
	}

//	public Model addModelAttributes(Model model){
//		model.addAttribute("countries", countryService.listOfCountry());
//		model.addAttribute("states", stateService.listOfState());
//		model.addAttribute("employees", employeeService.listOfEmployee());
//		return model;
//	}

	@RequestMapping(value="/employees/uploadPhoto", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File newFile = new File("D:\\SOLUTIONS\\fleetms\\uploads" + file.getOriginalFilename());
		newFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(newFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
	}	

	@PostMapping("/employees/uploadPhoto2")
	public String uploadFile2(@RequestParam("file") MultipartFile file, Principal principal) 
			throws IllegalStateException, IOException {
			String baseDirectory = "D:\\SOLUTIONS\\fleetms\\src\\main\\resources\\static\\img\\photos\\" ;
			file.transferTo(new File(baseDirectory + principal.getName() + ".jpg"));
			return "redirect:/employees";
	}

//	@RequestMapping(value="/employee/profile")
//	public String profile(Model model, Principal principal) {
//		String un = principal.getName();
//		addModelAttributes(model);
//		model.addAttribute("employee", employeeService.findByUsername(un));
//		return "profile";
//	}

	//The op parameter is either Edit or Details
//	@GetMapping("/hr/employee/{op}/{id}")
//	public String editEmployee(@PathVariable Integer id, @PathVariable String op, Model model){
//		Employee employee = employeeService.listOfEmployee();
//		model.addAttribute("employee", employee);
//		addModelAttributes(model);
//		return "/hr/employee"+ op; //returns employeeEdit or employeeDetails
//	}
}
