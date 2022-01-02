import java.util.List;

public class Login {
	
	int[] performLoginAdmin (String username, String password) {
		
		int check[] = {0,0,0}; // {exist,userType,index}
		
		for(int i=0; i<SystemDB.AdminList.size(); i++) {
			
			if(username.equals(SystemDB.AdminList.get(i).AdminName)) {
				if(password.equals(SystemDB.AdminList.get(i).password)) {
					check[0]=1;											// 1 exist || 0 not exist;
					check[1]=3;											// check[1] = Admin;
					check[2]=i;											// index;
					System.out.println("Admin Logged");
					return check;
				}
				else { System.err.println("wrong password"); }
			}
		}
		return check;
	}
	 
	
	int[] performLoginUser (String username, String password, List<User> user) {
		
		int check[] = {0,0,0}; // {exist,userType,index}
		
		
		for(int i=0; i<user.size(); i++) {
			
			if(username.equals(user.get(i).UserName)) {
				if(password.equals(user.get(i).password)) {
					check[0]=1;
					check[1]=1;											// check[1] = User;
					check[2]=i;
					System.out.println("User Successful Logged");
					return check;
				}
				else { System.err.println("wrong password"); }
			}
		}
		return check;
	}
	 
	 int[] performLoginDriver(String username, String password, List<Driver> driver) {
			
			int check[] = {0,0,0}; // {exist,userType,index}
			
			for(int j=0; j<driver.size(); j++) {
				if(username.equals(driver.get(j).UserName)) {
					if(password.equals(driver.get(j).password)) {
						if (driver.get(j).AccountStatus == true) {
							check[0]=1; check[1]=2; check[2]=j;					// check[1] = Driver;
							System.out.println("Driver Successfully Logged");
							return check;
						}
						else {
							System.out.println("ACCOUNT NOT YET ACTIVATED");	// Verify if driver's status is not yet true;
						}
					}
					else { 
						System.err.println("wrong password"); 
					}
				}
				
			}
		return check;
	}

	
}
