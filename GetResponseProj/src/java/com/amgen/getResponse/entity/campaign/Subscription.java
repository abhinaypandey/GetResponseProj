package com.amgen.getResponse.entity.campaign;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Subscription")
//@IdClass(SubscriptionPK.class)
public class Subscription implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_AUTO")
	@SequenceGenerator(name="USER_AUTO", sequenceName="USER_AUTO", allocationSize=1)
	@Column(name = "SubId")
	private int SubId;
	
	
	@Column(name = "USER_ID")
	private int USER_ID;
	
	@ManyToMany(fetch=FetchType.EAGER)
	ArrayList<Product> lst_Product = new ArrayList<Product>();

	public Subscription() {}
	
	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public ArrayList<Product> getLst_Campaign() {
		return lst_Product;
	}

	public void setLst_Campaign(ArrayList<Product> lst_Campaign) {
		this.lst_Product = lst_Campaign;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	@Id
//	@Column(name="productName")
//	private String productName;
//	
//	public Subscription() {}
//	
//	Subscription(SubscriptionPK spk) {
//		USER_ID = spk.getUSER_ID();
//		productName = spk.getProductName();
//	}
//	
//	@Id
//	@AttributeOverrides({
//	@AttributeOverride(name = "USER_ID", column = @Column(name = "USER_ID")),
//	@AttributeOverride(name = "productName", column = @Column(name="productName"))
//	})
//	
//	private SubscriptionPK spk;
//    
//		
//	@Column(name="email")
//    private String email;
//	
//	@Column(name="phone")
//    private String phone;
//	
//	@Column(name="fax")
//    private String fax;
//	
//	@Column(name="sms")
//    private String sms;
//	
//	@Column(name="directmail")
//    private String directmail;
//
//	public SubscriptionPK getSpk() {
//		return spk;
//	}
//
//	public void setSpk(SubscriptionPK spk) {
//		this.spk = spk;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getFax() {
//		return fax;
//	}
//
//	public void setFax(String fax) {
//		this.fax = fax;
//	}
//
//	public String getSms() {
//		return sms;
//	}
//
//	public void setSms(String sms) {
//		this.sms = sms;
//	}
//
//	public String getDirectmail() {
//		return directmail;
//	}
//
//	public void setDirectmail(String directmail) {
//		this.directmail = directmail;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
	
	
}
