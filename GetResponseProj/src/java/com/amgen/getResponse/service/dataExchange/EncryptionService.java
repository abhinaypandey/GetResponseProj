package com.amgen.getResponse.service.dataExchange;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;



public class EncryptionService {

	private boolean isArmored = false;
	private String id = "abhinay";
	private String passwd = "abhinay";
	private boolean integrityCheck = true;
	private String pubKeyFile;
	private String privKeyFile;
	private String plainTextFile;
	private String cipherTextFile;
	private String decPlainTextFile;
	private int encryBitLength=1024;

	public EncryptionService(File fileToEncrypt) {
		// TODO Auto-generated constructor stub
		pubKeyFile = "./User_Files/public.dat";
		privKeyFile = "./User_Files/private.dat";

		plainTextFile = fileToEncrypt.getAbsolutePath();
		cipherTextFile = "./User_Files/cypher-text.dat";
		decPlainTextFile = "./User_Files/dec-plain-text.txt";
	}
	

	
	public void genKeyPair() throws InvalidKeyException, NoSuchProviderException, SignatureException, IOException, PGPException, NoSuchAlgorithmException {
		
		RSAKeyPairGenerator rkpg = new RSAKeyPairGenerator();
																											
		Security.addProvider(new BouncyCastleProvider());

		KeyPairGenerator    kpg = KeyPairGenerator.getInstance("RSA", "BC"); 
		kpg.initialize(encryBitLength);

		KeyPair kp = kpg.generateKeyPair();

		FileOutputStream    out1 = new FileOutputStream(privKeyFile);
		FileOutputStream    out2 = new FileOutputStream(pubKeyFile);

		rkpg.exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), id, passwd.toCharArray(), isArmored);


	}

	public void encrypt() throws NoSuchProviderException, IOException, PGPException{
		FileInputStream pubKeyIs = new FileInputStream(pubKeyFile);
		FileOutputStream cipheredFileIs = new FileOutputStream(cipherTextFile);
		PgpHelper.getInstance().encryptFile(cipheredFileIs, plainTextFile, PgpHelper.getInstance().readPublicKey(pubKeyIs), isArmored, integrityCheck);
		cipheredFileIs.close();
		pubKeyIs.close();
	}

	
	public void decrypt() throws Exception{

		FileInputStream cipheredFileIs = new FileInputStream(cipherTextFile);
		FileInputStream privKeyIn = new FileInputStream(privKeyFile);
		FileOutputStream plainTextFileIs = new FileOutputStream(decPlainTextFile);
		PgpHelper.getInstance().decryptFile(cipheredFileIs, plainTextFileIs, privKeyIn, passwd.toCharArray());
		cipheredFileIs.close();
		plainTextFileIs.close();
		privKeyIn.close();
	}
	


}
