package beans;
// Generated 4 avr. 2017 18:57:40 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {

	private String username;
	private int id;
	private String password;
	private List<Address> address;


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
