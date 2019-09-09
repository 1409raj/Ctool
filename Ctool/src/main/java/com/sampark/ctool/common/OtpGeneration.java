package com.sampark.ctool.common;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class OtpGeneration {
	
	


    protected OtpGeneration() {
    }

    public static String random(int size) {

        StringBuilder generatedToken = new StringBuilder();
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i < size; i++) {
                generatedToken.append(number.nextInt(9));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedToken.toString();
    }
    
    public static void main(String[] args) {
    	
    	Encryptions td;
		try {
			td = new Encryptions();
			String unencryptedString=OtpGeneration.random(8);
			String encryptedString=td.encrypt(unencryptedString);
			String decrypt=td.decrypt(encryptedString);
			System.out.println(encryptedString+" "+decrypt+" "+unencryptedString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}


}
