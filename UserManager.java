package main;

import java.io.*;

//Class to handle storage and authentication of User information.
public class UserManager {
	
	//naming our user text file.
	public static final String FILE_NAME = "data/users.txt";
	
	//New user registration.
	public static void registerUser(String u, String p) throws IOException{
		
		//Hashing our password using our PasswordUtil class and storing the hashed password
		//Plain password is NEVER stored for security reasons.
		String hashed = PasswordUtil.hashPass(p);
		
		FileWriter fw = new FileWriter(FILE_NAME, true);
		fw.write(u + ":" + hashed + "\n");
		fw.close();
	}
	
	//User Authentication
	public static boolean authenticate(String u, String p) throws IOException{
		
		//comparing hashedInput vs storedHashed to authenticate.
		String hashedInput = PasswordUtil.hashPass(p);
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String line;
		
		//looping through our user.txt file, checking if the user name and password match
		while((line = br.readLine()) != null) {
			
			String[]parts = line.split(":");
			String storedUser = parts[0];
			String storedHash = parts[1];
			
			//if both user name and password match, the login is successful,
			//and the user has been authenticated
			if (storedUser.equals(u) && storedHash.equals(hashedInput)) {
				br.close();
				return true;
			}
		}
		
		br.close();
		return false;
	}
	
	
	
}
