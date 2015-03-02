package com.amgen.getResponse.entity.campaign;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="campaign")

public class Campaign {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USER_AUTO")
	@SequenceGenerator(name="USER_AUTO", sequenceName="USER_AUTO", allocationSize=1)
	@Column(name = "campaignId")
	
	public int campaignId;
	
	
	@ManyToMany
	ArrayList<Channel> lst_channel = new ArrayList<Channel>();
	
	public ArrayList<Channel> getLst_channel() {
		return lst_channel;
	}

	public void setLst_channel(ArrayList<Channel> lst_channel) {
		this.lst_channel = lst_channel;
	}

	@Column(name="campaignName")
    private String campaignName;
	
	public Campaign() {
		
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
}