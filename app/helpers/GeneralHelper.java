package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneralHelper {
	
	private static GeneralHelper self;
	
	private GeneralHelper(){}
	
	public static GeneralHelper getInstance(){
		if (self==null) {
			self =new GeneralHelper();
		}
		return self;
	}

	public String toMD5(String str){
		String result = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(str.getBytes()));  
	    	result = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
		return result;
	}

}
