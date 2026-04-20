package userAuthentication;

//Message Digest, allows for the cryptographic hash functions
import java.security.MessageDigest; 

//Checked exception. Thrown when the requested hashing algorithm is not supported by the current Java runtime
//Required by Java in order to use MessageDigest.getInstance().
import java.security.NoSuchAlgorithmException; 


//Utility Class to take care of hashing the password. It best practice to have these kinds of utilities in their own separate area from where they are executed from.
public class PasswordUtil {
	
	public static String hashPass(String password) {
		
		try {
			
			//Hash engine creation, configured to SHA-256
			//We then convert the inputed password into bytes in order for it to be compatible with hashing algorithm
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes());
			
			StringBuilder sb = new StringBuilder();
			
			//converting each byte into a hexadecimal 
			for (byte b : hash) {
				sb.append(String.format("%02x", b));
			}
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("password hashing has failed");
		}
	}
}
