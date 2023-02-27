package model;

public class Department {
	private int id;
	private String name;
	private String address;
	private String postalCode;

	public Department() {
		super();
	}

	public Department(String name, String address, String postalCode) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
	}

	public Department(int id, String name, String address, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
