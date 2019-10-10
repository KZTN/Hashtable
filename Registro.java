import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class Registro {
    private int key;
    private String value;
    private Registro proximo;
    public Registro() {
        this.proximo = null;
    }
    public Registro(int key, String value) {
        this.key = key;
        this.value = value;
        this.proximo = null;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getKey() {
        return this.key;
    }
    public String getValue() {
        return this.value;
    }
    public int hashCode() {
        return key%100;
    }
    public String hashCodeMD5() {
		try { 

			// Static getInstance method is called with hashing MD5 
			MessageDigest md = MessageDigest.getInstance("MD5"); 

			// digest() method is called to calculate message digest 
            // of an input digest() return array of byte 
            String textkey = Integer.toString(this.key);
			byte[] messageDigest = md.digest(textkey.getBytes()); 

			// Convert byte array into signum representation 
			BigInteger no = new BigInteger(1, messageDigest); 

			// Convert message digest into hex value 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		} 

		// For specifying wrong message digest algorithms 
		catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	} 
    public void setProximo(Registro proximo) {
        this.proximo = proximo;
    }
    public Registro getProximo() {
        return this.proximo;
    }
}