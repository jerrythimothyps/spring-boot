package com.example.springboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "todos")
public interface HelloClient {
	
	String baseUrl = "https://jsonplaceholder.typicode.com/";
	
	@GetMapping("/api/todos")
	public String getTodos() throws Exception;
	
	@GetMapping("/api/todos/{id}")
	public String getTodo(@PathVariable("id") int id) throws Exception;
	
	@PostMapping("/api/todos")
	public String postTodos(@RequestBody Todo todo) throws Exception;

	@PutMapping("/api/todos/{id}")
	public String putTodos(@PathVariable("id") int id, @RequestBody Todo todo) throws Exception;

	@DeleteMapping("/api/todos/{id}")
	public String deleteTodos(@PathVariable("id") int id) throws Exception ;
}
