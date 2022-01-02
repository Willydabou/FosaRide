import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Account {
	private
		String AdminPassword;
		String AdminName;
		String AdminID;
	public
		Registration registration = new AdminRegistration();
		// Driver driver = new Driver ();
	
	Admin () {
			// Default Constructor;
		}
		Admin (String aName, String aPassword) {
			this.AdminName = aName;
			this.AdminPassword = aPassword;
		}
	
		@SuppressWarnings({ "unused", "resource" })
		void VerifyRegistration(Driver aDriver) {									// 2) Verify Driver Registration;

			Scanner scI = new Scanner(System.in);									// for integer;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("   **  DRIVER REGISTRATION  **  ");
				
			System.out.println("List of Drivers not yet registered:\t");
			System.out.println("	--------------");
			
			DisplayPendingDrivers ();
				System.out.println("  Do you want to register a Driver? Press 1 if yes");
				 
				int ch = scI.nextInt();
				int nb = 1;
				if (ch == 1) {
					
					aDriver = SystemDB.DriverList.get(nb-1);
					aDriver.setAccountStatus(true);
					
					SystemDB.DriverList.set(nb-1, aDriver);
					
					// AcceptRegister (SystemDB.DriverList.get(nb));			// Setting account to true;		
					
					System.out.println("Driver added Successfully");
					DisplayPendingDrivers ();
				}
				else {
					System.out.println( "Thank you");
				}
			scI.close();
			
		}
		void SuspendAccount(Driver aDriver) {					// Suspend Driver Account;
			aDriver.setAccountStatus(false);
		}
		
		void AcceptRegistration (Driver aDriver) {
			aDriver.setAccountStatus(true);
		}
		
		public void DisplayAllDrivers() {				// 2) List all pending registrations;
			for(int i=0; i<SystemDB.DriverList.size(); i++) {
				System.out.println("Driver" + (i+1) + ":  " + SystemDB.DriverList.get(i).getUserName() + "\t\tStatus:  "  + SystemDB.DriverList.get(i).getStatus());
			}
		}
		
		public void DisplayPendingDrivers () {
			boolean isThere = false;							// NON REGISTERED DRIVERS;
			for(int i=0; i<SystemDB.DriverList.size(); i++) {
				if (SystemDB.DriverList.get(i).AccountStatus == false) {
					System.out.println("- " + (i+1) + ": "+ SystemDB.DriverList.get(i).getUserName());
					isThere = true;
				}
			}
			if (!isThere) {
				System.err.println("NO PENDING REGISTRATION");
			}
		}
		public String getAdminName() {
			return AdminName;
		}
		public void setAdminName(String adminName) {
			AdminName = adminName;
		}
		public String getAdminPassword() {
			return AdminPassword;
		}
		public void setAdminPassword(String adminPassword) {
			AdminPassword = adminPassword;
		}
		
		public void performRegistration() {
			List<String> AdminAccount = new ArrayList<>();
			AdminAccount = registration.AccountRegistration();
			this.AdminName = AdminAccount.get(0);
			this.AdminPassword = AdminAccount.get(1);
	}
}
