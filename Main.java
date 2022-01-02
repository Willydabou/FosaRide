import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		// SETTING 1 PREDEFINED ADMINS TO WORK WITH;
		
		Admin Admin1 = new Admin ();
		Admin1.AdminName = "Admin1";
		Admin1.password = "Password1";
		
		SystemDB.AdminList.add(Admin1);
		
		//  -------------------------------
		
		Scanner sc = new Scanner(System.in);			// Use when working with string
		Scanner in = new Scanner(System.in);			// Use when working with int to avoid runtime misunderstanding;
		
		
		boolean exit=true;
		
		while (exit) {
			System.out.println("\n======= WELCOME TO FosaRide ======== ");
			
			System.out.println("\n>>>> 1- LOGIN\t2- REGISTER\t3- EXIT <<<<");
			// Scanner in1 = new Scanner(System.in);
			int menu = in.nextInt();
			if(menu == 1) { 					// LOGIN
				
				System.out.println("======= LOGIN ==========");
				System.out.println("\n>>>> 1 - USER   2 - DRIVER   3 - ADMIN	4 - EXIT <<<<");
				int lg = in.nextInt();
				Login log = new Login();
				
					if (lg == 1) {
						System.out.println("\nUsername: ");
						String username =sc.nextLine();
						
						System.out.println("Password: ");
						String password = sc.nextLine();
						
						int[] temp;
						temp=log.performLoginUser(username,password,SystemDB.UserList);
						
						if(temp[0]==0) {
							System.err.println("Account do not exist "); 					//	Check account if exist
						}
						
						else {
							if(temp[1]==1) {												// 	User Account
								boolean proc = true;
								do {
									User user = new User();
									user = SystemDB.UserList.get(temp[2]);					// 	Searching with the index temp[2];
									
									System.out.println("\n>> 1-REQUEST RIDE  2-RATE DRIVER  3-CHECK AVERAGE RATE  4-Exit<<");
									int action = in.nextInt();
									
									if(action == 1) {									//	Request ride;
										
										Ride ride = new Ride ();
										ride = user.requestRide();
										
										if(user.rideNumber==0) {//--------------------------------------------------
											System.out.println("10% discount");
											user.rideNumber++;
										}
										if(ride.getPassengerNumber()==2) {//---------------------------------------
											System.out.println("5% discount");
										}
										
										ride.notifyDriver(SystemDB.DriverList);
										
										SystemDB.RideList.add(ride);
										SystemDB.UserList.set(temp[2], user);
									}
									
									if(action == 2) {								// Rate Driver;
										user.listofAllDrivers();					// list the drivers
										
										System.out.println("Rate which driver?");
										int ch = in.nextInt();							// Choose his ID;
										
										Driver driver = new Driver ();
										driver = SystemDB.DriverList.get(ch-1);
										
										user.RateDriver (driver);
										
										SystemDB.DriverList.set((ch-1), driver);
										
										SystemDB.UserList.set(temp[2], user);
									}
									
									if(action == 3) {								// Check Average Rating;
										
										user.listofAllDrivers();					// list the drivers
										
										System.out.println("Check which driver?");
										int ch = in.nextInt();						// Choose his indice;
										Driver driver = new Driver ();
										driver = SystemDB.DriverList.get(ch-1);
										
										user.checkAverageRatingofDriver(driver);
										
										SystemDB.DriverList.set(ch - 1, driver);
										SystemDB.UserList.set(temp[2], user);
									}
									
									if(action == 4) proc=false;
									
								} while(proc);
							}
						}
					}
							
				else if (lg == 2) { 									// DRIVER ACCOUNT;
					int[] temp;

					System.out.println("\nUsername: ");
					String username =sc.nextLine();
					
					System.out.println("Password: ");
					String password = sc.nextLine();
					
					temp=log.performLoginDriver(username,password,SystemDB.DriverList);
					
					if(temp[0]==0) {
						System.err.println("Account do not exist "); 					//	Check account if exist
					}
						
					else {
						boolean proc = true;
						do {
							
							Driver driver = new Driver();
							driver = SystemDB.DriverList.get(temp[2]);
									
							System.out.println("\n>> 1-ADD AREA  2-LIST RIDE  3-SUGGEST PRICE  4-LIST RATES  5-Exit<<");
							int action = in.nextInt();
									
								if(action == 1) {								// Add area
									driver.addFavoriteArea();
									SystemDB.DriverList.set(temp[2], driver);	// Setting the temporary driver back to the DB;
								}
									
								if(action == 2) {								// List Ride
									driver.listRides(SystemDB.RideList);
									SystemDB.DriverList.set(temp[2], driver);
								}
									
								if(action == 3) {								// Suggest Price to Ride
									driver.suggestPrice();
									SystemDB.DriverList.set(temp[2], driver);
								}
									
								if(action == 4) {								// List Ratings;
									driver.listAllRatings();
									SystemDB.DriverList.set(temp[2], driver);
								}
									
								if(action == 5) proc = false;					// EXIT
									
								} 	while(proc);		
					}
				}		
				else if (lg == 3) {							// PREDEFINED ADMINS;
					int[] temp;

					System.out.println("\nUsername: ");
					String username =sc.nextLine();
					
					System.out.println("Password: ");
					String password = sc.nextLine();
					
					/*
					 * Admin Admin1 = new Admin ();
					 * Admin1.AdminName = "Admin1";
					 * Admin1.password = "Password1";
					 */
					temp = log.performLoginAdmin(username,password);
					
					if(temp[0] == 0) {
						System.err.println("Account do not exist "); 					//	Check account if exist
					}
					
					else {	
					boolean proc = true;
						do {
							Admin admin = new Admin();
							admin = SystemDB.AdminList.get(0);					// Predefined Admin; 
							
							// System.out.println(admin.getAdminName());
									
							System.out.println("\n>> 1 - List Pending Drivers  2 - Approve Driver Registration  3 - Suspend Account	 4 - List All drivers   5-Exit<<");
							//Scanner Action = new Scanner(System.in);
							int Action1 = in.nextInt();
	
							if (Action1 == 1) {
								admin.DisplayPendingDrivers();
								proc = true;
							}
							
							else if (Action1 == 2) {
								if (SystemDB.DriverList.size() == 0) {
									System.err.println("NO DRIVER YET IN DATABASE");
								}
								else {															// VerifyRegistration
									System.out.println("   **  DRIVER REGISTRATION  **  ");
									
									admin.DisplayPendingDrivers ();
									
									System.out.println("Indice of Driver to Register?");
									int nb = in.nextInt();
									
									Driver aDriver = new Driver();
									aDriver = SystemDB.DriverList.get(nb-1);
									
									admin.AcceptRegistration(aDriver);						// Setting account to true;	
									System.out.println("Driver added .. ");
									
									SystemDB.DriverList.set(nb-1, aDriver);
								}
								proc = true;
							}
							
							else if (Action1 == 3) {											// Suspend Account;
								admin.DisplayAllDrivers();
								if (SystemDB.DriverList.size() == 0) {
									System.err.println("NO DRIVER YET IN DATABASE");
								}
								else {
									System.out.println("ID of Driver to suspend: ");
									int anID = in.nextInt();
									
									Driver driver = new Driver();
									driver = SystemDB.DriverList.get(anID-1);
									
									admin.SuspendAccount(driver);			// Set status to false;
									
									SystemDB.DriverList.set(anID-1,driver);
								}
								proc = true;
							}
							
							else if (Action1 == 4) {
								admin.DisplayAllDrivers();
								proc = true;
							}
							else proc = false;
							// Action.close();
						
						} while (proc);
					}
				}
			}
				
			else if (menu == 2)	{ 									// REGISTRATION;
				
				System.out.println("====== REGISTRATION ======");
				System.out.println("\n\t1- User\n\t2- Driver");
				int type = in.nextInt();
				
				if (type == 1) { 													// User Registration;
					User A = new User();
					A.performRegistration();
					
					SystemDB.UserList.add(A);
					
					
				}
				
				if (type == 2) {													// Driver Registration
					Driver B = new Driver();
					B.performRegistration();
					
					SystemDB.DriverList.add(B);
							
					System.out.println("Infos successfully registered...  \nWaiting for Admin Approval..."); 
							
				}
				
				if(type!=2 && type!=1) { System.out.println("Invalid Input"); }
			}
			
			else if (menu == 3) {
				System.out.println("Thanks for using FosaRide"); 
				exit=false;
			} 
			
			if(menu!=2 && menu!=1 && menu!=3)  System.err.println("Invalid input"); 
		}
		sc.close(); in.close();
	} 
}
