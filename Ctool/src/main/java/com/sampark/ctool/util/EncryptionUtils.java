package com.sampark.ctool.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class EncryptionUtils extends DriverManagerDataSource {

	private static final String characterEncoding = "UTF-8";
    private static final String cipherTransformation = "AES/CBC/PKCS5Padding";
    private static final String encryptionAlgorithm = "AES";
    private static final String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    
	@Override
	public String getPassword() {
		String password = super.getPassword();
		try {
			password = decryptPropertyValue(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

    private static byte[] decrypt(byte[] cipherText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpecy = new SecretKeySpec(key, encryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpecy, ivParameterSpec);
        cipherText = cipher.doFinal(cipherText);
        return cipherText;
    }
 
    private static byte[] encrypt(byte[] plainText, byte[] key, byte [] initialVector) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(cipherTransformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, encryptionAlgorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initialVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        plainText = cipher.doFinal(plainText);
        return plainText;
    }
    
    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException{
        byte[] keyBytes= new byte[16];
        byte[] parameterKeyBytes= key.getBytes(characterEncoding);
        System.arraycopy(parameterKeyBytes, 0, keyBytes, 0, Math.min(parameterKeyBytes.length, keyBytes.length));
        return keyBytes;
    }
    
    /**
     * Encrypts plaintext using AES 128bit key and a Chain Block Cipher and returns a base64 encoded string
     * @param plainText Plain text to encrypt
     * @return Base64 encoded string
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String encryptPropertyValue(String plainText) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    	Base64 base64 = new Base64();
        byte[] plainTextbytes = plainText.getBytes(characterEncoding);
        byte[] keyBytes = getKeyBytes(key);
        return base64.encodeToString(encrypt(plainTextbytes,keyBytes, keyBytes));
    }
 
    /**
     * Decrypts a base64 encoded string using the given key (AES 128bit key and a Chain Block Cipher)
     * @param encryptedText
     * @return Decrypted String
     * @throws Exception
     */
    public static String decryptPropertyValue(String encryptedText) throws Exception {
    	Base64 base64 = new Base64();
        byte[] cipheredBytes = base64.decode(encryptedText);
        byte[] keyBytes = getKeyBytes(key);
        return new String(decrypt(cipheredBytes, keyBytes, keyBytes), characterEncoding);
    }
     
    public static void main(String[] args) {
    	
    	String outputOfEncrypt = null;
    	String outputOfdecrypt = null;
    	try {
			System.out.println("EncryptionUtils.main() madhav");
			outputOfEncrypt = encryptPropertyValue("madhav");
			outputOfdecrypt = decryptPropertyValue(outputOfEncrypt);
			System.out.println("EncryptionUtils.main() " + outputOfEncrypt);
			System.out.println("EncryptionUtils.main() outputOfdecrypt " + outputOfdecrypt);
		} catch (Exception e1) {
			e1.printStackTrace();
		}     
    	
    	//System.out.println("Encrypted string "+ outputOfEncrypt);
    	
    	String outputOfDecrypt = null;
		try {
			outputOfDecrypt = decryptPropertyValue(outputOfEncrypt);
	        //System.out.println("[CryptoSecurity.outputOfDecrypt]:"+outputOfDecrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}        
    }
    
}
