package com.amgen.getResponse.dao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.exception.dao.DaoException;
import com.amgen.getResponse.utility.EntityManagerService;
import com.amgen.getResponse.utility.GetResponseLog;
import com.amgen.getResponse.utility.GetResponseLoggerFactory;
public class UserDaoImpl implements UserDao{
	EntityManager em = null;
	
	public User addUser(User user) throws DaoException{
		GetResponseLog log = GetResponseLoggerFactory.getLog("GetResponseLog");
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("EM created");

		try{
			System.out.println("Inside try");
			em.getTransaction().begin();
			System.out.println("before add");
			em.persist(user);
			System.out.println("after add");
			em.getTransaction().commit(); 
			em.flush();
			System.out.println("===> Flushed!!!");
		}catch(Exception e)
		{
			log.warn("method not found",e);
		}

		return user;
	}


	public User userLogin(String uname,String pword) {
		EntityManager em=null;

		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		em.getTransaction().begin();
		Query q = em.createQuery("Select U from User U where U.username=:username and U.password=:password");
		q.setParameter("username", uname);
		q.setParameter("password", pword);

		User u = (User) q.getSingleResult();
		if (uname.equalsIgnoreCase(u.getUsername())&&pword.equals(u.getPassword())) {
			System.out.println("user login:"+u.getUsername());
			System.out.println("login successfull..."); 
		}
		else {
			System.out.println("credentials mismatch...");

		}
		return u;
	}
	@Override
	public void deleteUser(String uname) {
		EntityManager em=null;
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("user to be deleted..."+uname);
		em.getTransaction().begin();
		System.out.println("user deleted...");
		Query q = em.createQuery("Select U from User U where U.username=:usname ");
		q.setParameter("usname", uname);
		User u=(User) q.getSingleResult();
		System.out.println("result set : " +q.getSingleResult());

		//User user=em.find(User.class, uname);
		em.remove(u);
		em.getTransaction().commit();
		em.flush();
		System.out.println("user deleted...");

	}

	public List<User> getUsers() {
		EntityManager em=null;
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("user deleted...");
	    em.getTransaction().begin();
		Query q = em.createQuery("Select U from User U");
		System.out.println(" after user deleted...");
		List<User> l = q.getResultList();
		
		System.out.println("count of result="+l.size());
		
		em.getTransaction().commit();
		return l;
	}

	public void updateUser(String username){
		EntityManager em=null;
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		em.getTransaction().begin();
		System.out.println("user to be updated..."+username);
		Query query = em.createQuery("UPDATE User u SET u.address = 'indira nagar' "
				+ "WHERE u.username= :username");

		query.setParameter("username", username);

		int updateCount = query.executeUpdate();

		if (updateCount > 0) {

			System.out.println("Done...");

		}
        em.getTransaction().commit();
		em.flush();
	}

	public User getUser(String username)

	{


//		EntityManager em=null;
//		try {
//			em = EntityManagerService.getEntityManager(0);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		System.out.println("user updated..."+username);
		User us=new User();
		em.getTransaction().begin();
		Query q = em.createQuery("Select U from User U where u.username=:username");
		System.out.println(" after user updation...");
		q.setParameter("username", username);
		User u = (User) q.getSingleResult();
		//em.merge(u);
		System.out.println(" minakshi chaudhary..."+u.getLast_name());
		em.merge(u);
		em.getTransaction().commit();em.flush();
		return u;

	}
	@Override
	public List<User> displayUser(String uname1) {
		// TODO Auto-generated method stub

		EntityManager em=null;
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("user updated..."+uname1);

		em.getTransaction().begin();
		Query q = em.createQuery("Select U from User U where u.username=:username");
		System.out.println(" after user updation...");
		q.setParameter("username", uname1);
		List<User> l = q.getResultList();
		//User u=(User) q.getSingleResult();
		System.out.println("result set : " +q.getResultList());
		em.getTransaction().commit();em.flush();
		return l;

	}


	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		try {
			em = EntityManagerService.getEntityManager(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
       
		System.out.println("user updated..."+u.getUsername());
		System.out.println("user updated..."+u.getAddress());
		
		em.getTransaction().begin();
		Query q = em.createQuery("Select U from User U where u.username=:username");
		q.setParameter("username", u.getUsername());
		User us1 = (User) q.getSingleResult(); 
		//em.find(User.class, u.getUsername());
		System.out.println("fetched username..."+us1.getUsername());
		us1.setAddress(u.getAddress());
		//us1.setEmail(u.getEmail());
		us1.setFax(u.getFax());
		us1.setFirst_name(u.getFirst_name());
		us1.setLast_name(u.getLast_name());
		us1.setPassword(u.getPassword());
		us1.setPhone(u.getPhone());
		//Query q = em.createQuery("Select U from User U where u.username=:username");
		System.out.println(" after user updation...");
		//q.setParameter("username", u.getUsername());
	    //u =  (User) q.getSingleResult();
	   // em.merge(u);
		//em.merge(us1);
		System.out.println(" minakshi chaudhary..."+u.getLast_name());
		//em.merge(us1);
		
		System.out.println(" my new entries..."+us1.getLast_name());
		em.getTransaction().commit();
		em.flush();
		System.out.println(" after commit..."+us1.getLast_name());
		return u;

		
		
		
		
		
		
		
		
		
		
	}


}



