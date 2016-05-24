package edu.ucla.its.itademo.util;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 6297385302078200511L;
	
	private String name;
	private String email;
	private int id;
	private String country;
	private String password;

	public User(String email, String password){
		this.password=password;
		this.email=email;
	}
	
	public User(String nm, String em, String country, int i){
		this.name=nm;
		this.id=i;
		this.country=country;
		this.email=em;
	}
	
	public User(String nm, String em, String country, String pass){
		this.name=nm;
		this.country=country;
		this.email=em;
		this.password=pass;
	}
	
	public User(String nm, String em, String country, int i, String pass){
		this.name=nm;
		this.id=i;
		this.country=country;
		this.email=em;
		this.password=pass;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return "Name="+this.name+", Email="+this.email+", Country="+this.country;
	}
}
