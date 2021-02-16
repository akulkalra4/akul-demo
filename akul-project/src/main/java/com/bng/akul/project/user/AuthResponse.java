package com.bng.akul.project.user;

public class AuthResponse {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	 
}
