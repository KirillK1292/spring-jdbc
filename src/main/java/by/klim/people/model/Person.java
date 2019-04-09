package by.klim.people.model;

import java.sql.Date;

public class Person {
	private Long id;
	private String firstName, lastName;
	private String sex;
	private Date birthdate;
	private String phone, email;
	
	public Person() {
		
	}
	
	public Person(Long id, String firstName, String lastName, String sex, Date birthdate, String phone, String email) {
		this.id = id;
		this.firstName= firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
