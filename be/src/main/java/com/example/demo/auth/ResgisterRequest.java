package com.example.demo.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResgisterRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
