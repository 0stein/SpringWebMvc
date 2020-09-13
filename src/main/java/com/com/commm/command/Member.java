package com.com.commm.command;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Member {
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	private String gender;
	private String position;
	private String[] hobby;
	private String hobbyString;
	
	
	//dao를 통해 mysql에 넣기 위해 급조한 변수인데... 최선인지 모르겠다.
	public String getHobbyString() {
		return hobbyString;
	}
	public void setHobbyString(String hobbyString) {
		this.hobbyString = hobbyString;
	}
	
	public String[] getHobby() {
		return this.hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return name+email+gender+position+hobby;
	}	
}
