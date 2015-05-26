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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import javassist.bytecode.Descriptor.Iterator;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.attribute.standard.Severity;

import org.bouncycastle.openpgp.PGPException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.lob.ReaderInputStream;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.service.BusinessService;
import com.amgen.getResponse.utility.EntityManagerService;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.HibernateUtil;
import com.amgen.getResponse.service.dataExchange.EncryptionService;
import com.amgen.getResponse.utility.*;

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
	
	private File getLatestFile(File dir){
		File[] filelist=dir.listFiles();
		if(filelist==null || filelist.length==0){
			return null;
		}
		
		File lastModified=filelist[0];
		for(int i=0;i<filelist.length;i++){
			if(lastModified.lastModified() < filelist[i].lastModified()){
				lastModified=filelist[i];
			}
		}
		return lastModified;
		
	}
	
	private boolean getDelimiterStatus(File latestFile,String currentDelimiter){
		boolean delimiterStatus=false;
		try {
			Scanner scan=new Scanner(latestFile);
			String currentLine;
			while(scan.hasNextLine()){
				currentLine=scan.nextLine();
				if(currentLine.contains(currentDelimiter)){
					delimiterStatus=false;
					continue;
				}
				else
					delimiterStatus=true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delimiterStatus;
	}
	
	private static void fetchData(File file,String filePath,String delimiter) throws SQLException{
		try {
//			FileOutputStream f=new FileOutputStream(file);

			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,true)),true);
			
			Repository rep=new HibernateRepository();
			
			@SuppressWarnings("unchecked")
			List<User> users=(List<User>)rep.retrieve(User.class);
			
			if(!users.isEmpty()){
				java.util.Iterator<User> iterator=users.iterator(); 
				
				while(iterator.hasNext()){
					User user=(User)iterator.next();
					pw.print(user.getId()); pw.print(delimiter);
					pw.print(user.getUsername());pw.print(delimiter);
					pw.print(user.getFirst_name());pw.print(delimiter);
					pw.print(user.getLast_name());pw.print(delimiter);
					pw.print(user.getEmail());pw.print(delimiter);
					pw.print(user.getPhone());
					pw.println("");
					pw.flush();
					
				}
				
				/* Calling EncryptionService to handle data encryption and Decryption */
				try {
					EncryptionService test=new EncryptionService(file);
					
						test.genKeyPair();
						test.encrypt();
						test.decrypt();
					} catch (InvalidKeyException e){
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchProviderException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SignatureException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PGPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						pw.close();
					}
					
					
					System.out.println("Data encrypted successfully");
			}
			else{
				System.out.println("No users found registered");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DataTransfer() throws Exception{
		    System.out.println("Data transfer called");
			DataExchangeServiceImpl dimpl=new DataExchangeServiceImpl();
			ResourceBundle rc=ResourceBundle.getBundle("properties.delimiter");
			String delimiter=rc.getString("delimiter");
			/*Extracting previous file delimiter from stored files 
			 * */
			
//			String regexp="^\\d$";
//			Pattern pattern=Pattern.compile(regexp);
	
			
			File dir=new File("User_Files");
			String latestFile="";
			File lastModified=dimpl.getLatestFile(dir);
//			File[] flist=dir.listFiles();
//			ArrayList<File> files=new ArrayList<File>();
//			for(File file:flist){
//				if(file.isFile()){
//					files.add(file);
//				}
//			}
//			List<String> filenames=new ArrayList<String>();
//			Set<String> fileset=new TreeSet<String>(filenames);
			
//			for(File f :filelist){
//				if(f.isFile()){
//				   
//					String str=pattern.compile(regexp).matcher(f.getName()).replaceAll("\\D+","");
//					String num=f.getName().replaceAll("\\D+", "");
//					if(num.isEmpty()){
//						continue;
//					}
//					else{
//						fileset.add(f.getName().replaceAll("\\D+", ""));
//						latestFile=f.getAbsolutePath();
//					}
//					
//					
//				}
//			}
			boolean delimiterStatus = dimpl.getDelimiterStatus(lastModified,delimiter);
			if(delimiterStatus){
				System.out.println("delimiter :  "+delimiterStatus);
				long timestamp=new Date().getTime();
				String filePath="./User_Files/userData_"+timestamp+".txt";
				File headerFile=new File("./User_Files/userDataTemplate.txt");
				InputStreamReader ir=new InputStreamReader(new FileInputStream(headerFile));
				BufferedReader bf=new BufferedReader(ir);
				File file=new File(filePath);
				PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file)),true);
				String header=bf.readLine();
				pw.println(header);
				pw.close();
				fetchData(file,filePath,delimiter);
					
				
			}
			else{
				fetchData(lastModified,lastModified.getAbsolutePath(),delimiter);
			}
			
			
		
	}

}
