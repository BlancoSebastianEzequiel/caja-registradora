package ar.fiuba.tdd.tp2;

public class User {
	private Role role;
	private String username;
	private String password;
	
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
	
	public void canLogIn() {
		this.role.canLogIn();
	}
	public void canLogOut() {
		this.role.canLogOut();
	}
}
