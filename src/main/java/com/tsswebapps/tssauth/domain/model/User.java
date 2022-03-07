package com.tsswebapps.tssauth.domain.model;

import java.util.List;

public class User {
	private Long id;
	private String email;
	private String name;
	private String password;
	private List<Roles> role;
}
