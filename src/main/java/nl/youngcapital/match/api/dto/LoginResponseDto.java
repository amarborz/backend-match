package nl.youngcapital.match.api.dto;

public class LoginResponseDto {
	
	private boolean success;

	private String token;
	
	private String name;
	
	private String role;
	
	private long id;
	
	public LoginResponseDto(boolean success, String token, String name, String role, long id) {
		super();
		this.success = success;
		this.token = token;
		this.name = name;
		this.role = role;
		this.id = id;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
