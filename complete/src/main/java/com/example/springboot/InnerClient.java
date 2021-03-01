package com.example.springboot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerClient {
	public String id;
	public String firstName;
	public String lastName;
	public ClientRole clientRole;
	public String state;
}
