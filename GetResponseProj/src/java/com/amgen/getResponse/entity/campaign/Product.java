/**
 *
 * This comment is NOT a class level javadoc comment. 
 * 
 * @description: 
 * @author: singhda
 * @version: 
 *
 */
package com.amgen.getResponse.entity.campaign;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="product")

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_AUTO")
	@SequenceGenerator(name="USER_AUTO", sequenceName="USER_AUTO", allocationSize=1)
	@Column(name = "productId")
	public int productId;	
	
	
	@OneToMany
	ArrayList<Campaign> lst_campaign = new ArrayList<Campaign>();
	
	@Column(name="productName")
    private String productName;
	
	public Product() {}
	
	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public ArrayList<Campaign> getLst_campaign() {
		return lst_campaign;
	}


	public void setLst_campaign(ArrayList<Campaign> lst_campaign) {
		this.lst_campaign = lst_campaign;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}	
	
}
