import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Account {
	Scanner sc = new Scanner(System.in);
	List<Ride> rideList= new ArrayList<>();
	public static int rideNumber=0;
	
	private 
		String userID;
		Registration registration = new UserRegistration();
		int averageRate;
	
	public 
		void performRegistration() {
			List<String> userAccount = new ArrayList<>();
			userAccount = registration.AccountRegistration();
			this.UserName = userAccount.get(0);
			this.userID = userAccount.get(1);
			this.eMail = userAccount.get(2);
			this.password = userAccount.get(3);
			this.mobileNumber = userAccount.get(4);
			// this.accountStatus = true;
		
			/* @SuppressWarnings("unused")
		User user = new User();
		System.out.println("==========User Registration==========");
		
		// List<String> userAccount = new ArrayList<>();
		System.out.println("userName: ");
		String username= sc.nextLine();
		user.UserName = username;
		// userAccount.add(username);
		
		System.out.println("User id: ");
		String userid=sc.nextLine();
		user.setUserID (userid);
		//userAccount.add(userid);
		
		System.out.println("User email: ");
		String email=sc.nextLine();
		user.eMail = email;
		//userAccount.add(email);
		
		System.out.println("User Password: ");
		String password= sc.nextLine();
		user.password = password;
		// userAccount.add(password);
		
		System.out.println("User mobile number: ");
		String mobilenumber= sc.nextLine();
		// userAccount.add(mobilenumber);
		user.mobileNumber = mobilenumber;
		SystemDB.UserList.add(user); */
		}
	
	
	
		//void setUserID(String id) { this.userID=id; }
		String getUserID() { return userID; }
		String getUserName() { return UserName; }
		String getEmail() { return eMail; }
		String getPassword() { return password; }
		String getMobileNumber() { return mobileNumber; }
		
		Ride requestRide() {
			Ride ride = new Ride();
			System.out.println("\nEnter Ride Source: ");
			String source = sc.nextLine();
			
			System.out.println("Enter Ride destination: ");
			String destination = sc.nextLine();
			
			ride.setSource(source);
			ride.setDestination(destination);
			
			Driver.RequestRides.add(ride);				// Adding the ride to the list in the driver;
			return ride;
		}
		
		void checkAverageRatingofDriver (Driver aDriver) {
			System.out.println("Driver Name \t\tDriver ID\t\tMobile Number");
			System.out.println(aDriver.UserName + "\t\t\t" + aDriver.getDriverID() + "\t\t\t" + aDriver.mobileNumber);
			System.out.println("\nThe average rating of this driver is: " + aDriver.AverageRating());
		}
		
		void listofAllDrivers () {
			for (int i = 0; i<SystemDB.DriverList.size(); i++) {
				System.out.println(SystemDB.DriverList.get(i).getDriverID());
			}
		}
		
		void RateDriver (Driver aDriver) {
			System.out.println("Give your rating: (from 1 to 5)");
			short aRating = sc.nextShort();
			boolean done = false;
			do {
				
				if (aRating != 1 && aRating != 2 && aRating != 3 && aRating != 4 && aRating != 5 ) {
					System.err.println("Rating only between [0 - 5]");
					aRating = sc.nextShort();
				}
				else {
					aDriver.userRating.add(aRating);						// Adding the rating to the Database;
					System.out.println("\nYou gave a rating of " + aRating + " to " + aDriver.UserName);
					System.out.println("\nThanks for your rating ... ");
					done = true;
				}
			} while (!done);
		}
		public void setUserID(String userid2) {
			this.userID = userid2;
		}
	
}
