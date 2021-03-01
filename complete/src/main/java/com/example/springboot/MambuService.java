package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

@RestController
public class MambuService implements MambuClient {

	String authentication = "Basic bWFtYnVfYXBpOm1hbWJ1MjAyMCEh";
	String accept = "application/json";
	String contentType = "application/json";

	public String getClients() throws Exception {
		return Unirest.get(baseUrl + "clients").header("Accept", accept).header("Content-Type", contentType)
				.header("Authorization", authentication).asString().getBody();
	}

	public String getClient(String id) throws Exception {
		return Unirest.get(baseUrl + "clients/" + id).header("Accept", accept).header("Content-Type", contentType)
				.header("Authorization", authentication).asString().getBody();
	}

	public String postClients(Client client) throws Exception {
		ObjectMapper obj = new ObjectMapper();
		HttpResponse<JsonNode> jsonResponse = Unirest.post(baseUrl + "clients").header("Accept", accept)
				.header("Content-Type", contentType).header("Authorization", authentication)
				.body(obj.writeValueAsString(client)).asJson();

		return jsonResponse.getBody().toString();

	}

	public String patchClients(String id, Client client) throws Exception {
		ObjectMapper obj = new ObjectMapper();
		HttpResponse<JsonNode> jsonResponse = Unirest.patch(baseUrl + "clients/" + id).header("Accept", accept)
				.header("Content-Type", contentType).header("Authorization", authentication)
				.body(obj.writeValueAsString(client)).asJson();

		return jsonResponse.getBody().toString();

	}

	public String deleteClients(String id) throws Exception {
		return Unirest.delete(baseUrl + "clients/" + id).header("Accept", accept).header("Content-Type", contentType)
				.header("Authorization", authentication).asString().getBody();

	}

}
