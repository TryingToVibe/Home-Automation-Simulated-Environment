package main;

public class User {
	
	//User's user name and password. 
	private String username;
	private String hashedPass;
	private Role role;
	
	//Constructor
	public User(String u, String hp, Role role) {
		this.username = u;
		this.hashedPass = hp;
		this.role = role;
	}
	
	
	//Basic getters
	public String getUsername() {
		return username;
	}
	
	public String getHashedPassword() {
		return hashedPass;
	}
	
	public Role getRole() {
		return role;
	}
}
