package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@RestController
public class HelloService implements HelloClient {

	public String getTodos() throws Exception {
		return Unirest.get(baseUrl + "posts").asString().getBody();
	}

	public String getTodo(int id) throws Exception {
		return Unirest.get(baseUrl + "posts/" + id).asString().getBody();
	}

	public String postTodos(Todo todo) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.post(baseUrl + "posts").body(todo.toString()).asJson();

		return jsonResponse.getBody().toString();

	}

	public String putTodos(int id, Todo todo) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.put(baseUrl + "posts/" + id).body(todo.toString()).asJson();

		return jsonResponse.getBody().toString();

	}

	public String deleteTodos(int id) throws Exception {
		return Unirest.delete(baseUrl + "posts/" + id).asString().getBody();

	}

}
