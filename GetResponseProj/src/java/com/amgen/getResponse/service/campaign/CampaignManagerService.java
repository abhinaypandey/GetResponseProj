/**
 *
 * This comment is NOT a class level javadoc comment. 
 * 
 * @description: 
 * @author: singhda
 * @version: 
 *
 */
package com.amgen.getResponse.service.campaign;

import java.util.List;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.service.BusinessService;

public interface CampaignManagerService extends BusinessService {

	public List<Product> getProducts();
	public List<Channel> getChannels();

	public List<Product> getProducts(String userName);
	public List<Channel> getChannels(String userName);

	public String saveProducts(List<Product> productList);
	public String saveChannels(List<Channel> channelList);


	public String deleteProducts(List<Product> productList);
	public String deleteChannels(List<Channel> channelList);


	public String updateProducts(List<Product> productList);
	public String updateChannels(List<Channel> channelList);


}
