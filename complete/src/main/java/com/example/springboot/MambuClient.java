package com.example.springboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mambu")
public interface MambuClient {

	String baseUrl = "https://publicissapient.sandbox.mambu.com/api/";

	@GetMapping("/api/clients")
	public String getClients() throws Exception;

	@GetMapping("/api/clients/{id}")
	public String getClient(@PathVariable("id") String id) throws Exception;
	
	@PostMapping("/api/clients")
	public String postClients(@RequestBody Client client) throws Exception;

	@PatchMapping("/api/clients/{id}")
	public String patchClients(@PathVariable("id") String id, @RequestBody Client client) throws Exception;

	@DeleteMapping("/api/clients/{id}")
	public String deleteClients(@PathVariable("id") String id) throws Exception ;
}
