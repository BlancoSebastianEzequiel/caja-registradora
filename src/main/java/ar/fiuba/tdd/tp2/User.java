package ar.fiuba.tdd.tp2;

public class User {
	private Role role;
	private String username;
	private String password;
	private Boolean isLoggedIn;
	
	public User(String username, String password, Role aRole) {
		this.username = username;
		this.password = password;
		this.role = aRole;
	}
	public void canOpen() {
		this.role.canOpen();
	}

	public void canClose() {
		this.role.canClose();
	}

	public String getUsername() {
		return this.username;
	}

	void logIn() {
		this.isLoggedIn = true;
	}

	void logOut() {
		this.isLoggedIn = false;
	}

	Boolean IsUserLoggedIn() {
		return this.isLoggedIn;
	}

	Boolean isCashier() {
		return this.role.isCashier();
	}

}
