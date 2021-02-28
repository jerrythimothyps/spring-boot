package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	HelloService helloService = new HelloService();

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/api/todos")
	public String getTodos() throws Exception {
		return helloService.getTodos();// return
										// Unirest.get("https://jsonplaceholder.typicode.com/posts").asString().getBody();
	}

	@GetMapping("/api/todos/{id}")
	public String getTodo(@PathVariable("id") int id) throws Exception {
		return helloService.getTodo(id);
	}

	@PostMapping("/api/todos")
	public String postTodos(@RequestBody Todo todo) throws Exception {
		return helloService.postTodos(todo);
	}

	@PutMapping("/api/todos/{id}")
	public String putTodos(@PathVariable("id") int id, @RequestBody Todo todo) throws Exception {
		return helloService.putTodos(id, todo);
	}

	@DeleteMapping("/api/todos/{id}")
	public String deleteTodos(@PathVariable("id") int id) throws Exception {
		return helloService.deleteTodos(id);

	}

}
