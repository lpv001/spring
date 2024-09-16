package com.session.home.util;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class FileScrty {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileScrty.class);
    // 파일구분자
    static final char FILE_SEPARATOR = File.separatorChar;

    static final int BUFFER_SIZE = 1024;
/*
/* //취약점 문제로 인해 사용하지 않는 함수 주석. 2021.02.09 박경덕
    *//**
     * 데이터를 암호화하는 기능
     *
     * @param data 암호화할 데이터
     * @return String result 암호화된 데이터
     * @exception Exception
     *//*
    public static String encodeBinary(byte[] data)   {
		if (data == null) {
		    return "";
		}

		return new String(Base64.encodeBase64(data));
    }

    *//**
     * 데이터를 복호화하는 기능
     *
     * @param data 복호화할 데이터
     * @return String result 복호화된 데이터
     * @exception Exception
     *//*
    public static byte[] decodeBinary(String data)   {
    	return Base64.decodeBase64(data.getBytes());
    }*/

    /**
     * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
     *
     * @param password 암호화될 패스워드
     * @param id salt로 사용될 사용자 ID 지정
     * @return
     * @ 
     */
    public static String encryptPassword(String password, String id) {

		if (password == null) {
		    return "";
		}
		String enc = "";
		try {

			byte[] hashValue = null; // 해쉬값

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			md.reset();
			md.update(id.getBytes());

			hashValue = md.digest(password.getBytes());
			enc = new String(Base64.encodeBase64(hashValue));
		}catch (NoSuchAlgorithmException e){
			return enc;
		}
		return enc;
    }

    /**
     * 비밀번호를 암호화하는 기능(복호화가 되면 안되므로 SHA-256 인코딩 방식 적용)
     * @param data 암호화할 비밀번호
     * @param salt Salt
     * @return 암호화된 비밀번호
     * @ 
     */
    public static String encryptPassword(String data, byte[] salt) {

		if (data == null) {
		    return "";
		}
		String enc = "";
		try {
			byte[] hashValue = null; // 해쉬값

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			md.reset();
			md.update(salt);

			hashValue = md.digest(data.getBytes());

			enc = new String(Base64.encodeBase64(hashValue));
		}catch (NoSuchAlgorithmException e){
			return enc;
		}
		return enc;
    }

    /**
     * 비밀번호를 암호화된 패스워드 검증(salt가 사용된 경우만 적용).
     *
     * @param data 원 패스워드
     * @param encoded 해쉬처리된 패스워드(Base64 인코딩)
     * @return
     * @ 
     */
    public static boolean checkPassword(String data, String encoded, byte[] salt) throws NoSuchAlgorithmException {
    	byte[] hashValue = null; // 해쉬값

    	MessageDigest md = MessageDigest.getInstance("SHA-256");

    	md.reset();
    	md.update(salt);
    	hashValue = md.digest(data.getBytes());

    	return MessageDigest.isEqual(hashValue, Base64.decodeBase64(encoded.getBytes()));
    }

	public static String extractStringHashSHA256(String str) {

		String SHA = "";

		try {

			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.reset();
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for( int i=0; i<byteData.length; i++ ) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			////e.printStackTrace();
			LOGGER.debug("extract error : extractStringHashSHA256" );
			SHA = null;
		}

		return SHA;

	}

	/*
	public static String extractFileHashSHA256(String filename) throws IOException, NoSuchAlgorithmException {

		String SHA = "";
		int buff = 16384;

		RandomAccessFile file = new RandomAccessFile(filename, "r");

		MessageDigest hashSum = MessageDigest.getInstance("SHA-256");

		byte[] buffer = new byte[buff];
		byte[] partialHash = null;

		long read = 0;

		long offset = file.length();
		int unitsize = 0;
		try{
			if(read >= offset){
				hashSum.reset();
				hashSum.update(buffer, 0, unitsize);
			}
			while( read < offset ) {
				unitsize = (int)(((offset - read) >= buff) ? buff : (offset - read));
				hashSum.reset();
				hashSum.update(buffer, 0, unitsize);
				file.read(buffer, 0, unitsize);
				read += unitsize;
			}
		}catch (IOException e){
			LOGGER.debug("file read exception : extractFileHashSHA256");
		}finally {
			EgovResourceCloseHelper.close(file);
		}



		//partialHash = new byte[hashSum.getDigestLength()];
		partialHash = hashSum.digest();

		StringBuffer sb = new StringBuffer();
		for( int i=0; i<partialHash.length; i++ ) {
			sb.append(Integer.toString((partialHash[i]&0xff) + 0x100, 16).substring(1));
		}
		SHA = sb.toString();

		return SHA;

	}

	*/
	
	public static byte[] hmacSHA256(byte[] key, String data) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(key, "HmacSHA256");
		sha256_HMAC.init(secret_key);

		return sha256_HMAC.doFinal(data.getBytes("UTF-8"));

	}

}