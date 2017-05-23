package beans;
// Generated 4 avr. 2017 18:57:40 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {
	public static final String salt="chips";
	private String username;
	private int id;
	private String password;
	private String name;
	private String surname;
	private String description;
	private String picture;
	private List<Address> address;

	public Client() {
	}
	
	public Client(String username, int id, String password, List<Address> address) {
		this.username = username;
		this.id = id;
		this.password = password;
		this.address = address;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return this.address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
