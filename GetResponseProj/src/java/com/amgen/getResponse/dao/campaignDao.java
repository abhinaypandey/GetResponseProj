package com.amgen.getResponse.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.campaign.Subscription;
import com.amgen.getResponse.entity.campaign.SubscriptionPK;
import com.amgen.getResponse.utility.EntityManagerService;
public class campaignDao {
			public List findUser(int id) throws IOException, SQLException {
				EntityManager em = EntityManagerService.getEntityManager(1);
				//Query q = em.createQuery("Select s from Subscription s where s.spk.USER_ID=:id");
				//q.setParameter("id", id);
//				Subscription sp = new Subscription();
//				SubscriptionPK spk = new SubscriptionPK();
//				spk.setU_id(id);
//				sp.setSpk(spk);
//				sp.setU_id(id);
	            List sub = null;
	            Subscription pd = new Subscription();
	            em.persist(pd);
	            //System.out.println("result set : "+ q.getResultList());
	            //sub = q.getResultList();
	            //sub = (List) em.find(Subscription.class, spk);
				return sub;
			}
			
}
