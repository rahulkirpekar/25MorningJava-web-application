package com.royal.bean;

public class StudentBean 
{
	private int id;
    private String fullName; 
    private int age;
    private String course;
    private String gender; 
    private String hobbies[];
    private String dob;
    private String email;
    private String mobile;
    private String address;
    
    public StudentBean() 
    {
	}

	public StudentBean(int id, String fullName, int age, String course, String gender, String[] hobbies, String dob,
			String email, String mobile, String address) {
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.course = course;
		this.gender = gender;
		this.hobbies = hobbies;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
