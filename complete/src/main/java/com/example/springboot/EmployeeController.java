package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EmployeeController {

	@RequestMapping("/api/employee")
	public String index() {
		return "Greetings from Employee Boot!";
	}

}
