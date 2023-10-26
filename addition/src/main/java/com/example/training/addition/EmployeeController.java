package com.example.training.addition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Marking this class as Spring MVC Controller
public class EmployeeController {
	@Autowired //Requesting for EmployeeService object to be injected
	private EmployeeService service;
	
	@GetMapping(path="/employees/{empId}")
 	@ResponseBody
	public ResponseEntity getEmployee(@PathVariable("empId")Integer empId) {
		ResponseEntity response = null;
		Employee emp = service.findEmployeeById(empId);
		if(emp != null) {
			response = new ResponseEntity(emp, HttpStatus.FOUND); //returning string + 200
			return response;
		}else {
			response = new ResponseEntity("Employee Not Found", HttpStatus.NOT_FOUND); //returning string + 200
			return response;
		}
	}
}

