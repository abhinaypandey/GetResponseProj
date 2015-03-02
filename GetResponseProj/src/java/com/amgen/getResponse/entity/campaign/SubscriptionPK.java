package com.amgen.getResponse.entity.campaign;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class SubscriptionPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int USER_ID;
	private String productName;
	
	public SubscriptionPK() {}
	
	public int hashCode() {
        return (int) productName.hashCode() + USER_ID;
    }

    public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof SubscriptionPK)) return false;
        if (obj == null) return false;
        SubscriptionPK pk = (SubscriptionPK) obj;
        return pk.USER_ID == USER_ID && pk.productName.equals(productName);
    }

}
