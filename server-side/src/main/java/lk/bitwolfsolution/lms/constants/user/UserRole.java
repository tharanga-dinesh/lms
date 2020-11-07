package lk.bitwolfsolution.lms.constants.user;

public enum UserRole {

	ADMIN(0,"Admin"),
	OFFICER(1, "Officer");

	private Integer id;
	private String name;

	private UserRole(Integer id, String name) {
		setId(id);
		setName(name);
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
