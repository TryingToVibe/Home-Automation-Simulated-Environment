package userAuthentication;



import java.io.*;

//Class to handle storage and authentication of User information.
public class UserManager {
	
	//naming our user text file.
	public static final String FILE_NAME = "users.txt";
	
	//New user registration.
	public static void registerUser(String u, String p) throws IOException{
		
		File file = new File(FILE_NAME);
        String hashed = PasswordUtil.hashPass(p);
        Role role;
        
        
        if (!file.exists() || file.length() == 0) {

            role = Role.ADMIN;
            System.out.println("Creating first ADMIN account.");

        } else {
        	if (!Session.isAdmin()) {
                System.out.println("Access denied. Only admins can create users.");
                return;
            }

            role = Role.GUEST;
        }
		
		//Hashing our password using our PasswordUtil class and storing the hashed password
		//Plain password is NEVER stored for security reasons.
		
		FileWriter fw = new FileWriter(FILE_NAME, true);
		fw.write(u + ":" + hashed + ":" + role + "\n");
		fw.close();
	}
	
	//User Authentication
	public static User authenticate(String u, String p) throws IOException{
		
		//comparing hashedInput vs storedHashed to authenticate.
		String hashedInput = PasswordUtil.hashPass(p);
		
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String line;
		
		//looping through our user.txt file, checking if the user name and password match
		while((line = br.readLine()) != null) {
			
			String[]parts = line.split(":");
			String storedUser = parts[0];
			String storedHash = parts[1];
			Role role = Role.valueOf(parts[2]);
			
			//if both user name and password match, the login is successful,
			//and the user has been authenticated
			if (storedUser.equals(u) && storedHash.equals(hashedInput)) {
				br.close();
				return new User(storedUser, storedHash, role);
			}
		}
		
		br.close();
		return null;
	}
	
	
	
}
