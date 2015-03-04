/**
 *
 * This comment is NOT a class level javadoc comment. 
 * 
 * @description: This class fetches data and calls encryption service 
 * @author: abhinay
 * @version: 
 *
 */
package com.amgen.getResponse.service.dataExchange;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javassist.bytecode.Descriptor.Iterator;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bouncycastle.openpgp.PGPException;
import org.hibernate.lob.ReaderInputStream;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.utility.EntityManagerService;
import com.amgen.getResponse.service.dataExchange.EncryptionService;

public class DataExchangeServiceImpl implements DataExchangeService {

	@Override
	public void service() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(String str) {
		// TODO Auto-generated method stub 
		
	}

	@Override
	public void service(String str, Object obj) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String arg[]) throws Exception{
		try {
			
			
			long timestamp=new Date().getTime();
			File headerFile=new File("./User_Files/userDataTemplate.txt");
			InputStreamReader ir=new InputStreamReader(new FileInputStream(headerFile));
			BufferedReader bf=new BufferedReader(ir);
			String filePath="./User_Files/userData_"+timestamp+".txt";
			File file=new File(filePath);
			
//			FileOutputStream f=new FileOutputStream(file);
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
			String header=bf.readLine();
			pw.println(header); 
			
			EntityManager em=EntityManagerService.getEntityManager(0);
			em.getTransaction().begin();
			javax.persistence.Query q= em.createQuery("Select o from User o");
			List<User> users=q.getResultList();
			java.util.Iterator<User> iterator=users.iterator(); 
			
			ResourceBundle rc=ResourceBundle.getBundle("properties.delimiter");
			String delimiter=rc.getString("delimiter");
			
			while(iterator.hasNext()){
				User user=iterator.next();
				pw.print(user.getId()); pw.print(delimiter);
				pw.print(user.getUsername());pw.print(delimiter);
				pw.print(user.getFirst_name());pw.print(delimiter);
				pw.print(user.getLast_name());pw.print(delimiter);
				pw.print(user.getEmail());pw.print(delimiter);
				pw.print(user.getPhone());
				pw.println("");
				pw.flush();
				
			}
			
			/* Calling EncryptionService to handle data encrytpion and decryption */
			
			EncryptionService test=new EncryptionService(filePath);
			test.genKeyPair();
			test.encrypt();
			test.decrypt();
			
			System.out.println("Data encrypted successfully");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
