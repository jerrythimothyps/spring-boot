package com.example.springboot;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientRole {
	public String encodedKey;
}
