package com.amgen.getResponse.entity.userProfileManagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.amgen.getResponse.entity.campaign.Subscription;
import com.amgen.getResponse.utility.GetResponseLog;
import com.amgen.getResponse.utility.GetResponseLoggerFactory;

@Entity
@Table(name="User")

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_AUTO")
	@SequenceGenerator(name="USER_AUTO", sequenceName="USER_AUTO", allocationSize=1)
    private int id;
//	
//	@OneToMany
//	Subscription subscription;
//	
//	
//	public Subscription getSubscription() {
//		return subscription;
//	}

//	public void setSubscription(Subscription subscription) {
//		this.subscription = subscription;
//	}

	@Column(name="First_Name")
    private  String first_name;
	
	@Column(name="Last_Name")
    private String last_name;
	
	@Column(name="USER_NAME")
	public String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private int phone;
	
	@Column(name="Address")
	private String address;
	
	@Column (name="Fax")
	private int fax;
	

	public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getFax() {
	return fax;
}

public void setFax(int fax) {
	this.fax = fax;
}

	public User() {
		
	}
	
	public int getId() {
		 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
		}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		
		this.phone = phone;
	}
	
	
	
}
