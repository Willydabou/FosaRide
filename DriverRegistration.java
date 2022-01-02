import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverRegistration implements Registration{
	Scanner sc = new Scanner(System.in);
	@Override
	public List<String> AccountRegistration() {
		@SuppressWarnings("unused")
		Driver driver = new Driver();
		System.out.println("Driver Registration");
		
		List<String> driverAccount = new ArrayList<>();
		System.out.println("userName: ");
		String username= sc.nextLine();
		driverAccount.add(username);
		
		System.out.println("Driver id: ");
		String userid=sc.nextLine();
		driverAccount.add(userid);
		
		System.out.println("Driver email: ");
		String email=sc.nextLine();
		driverAccount.add(email);
		
		System.out.println("Driver Password: ");
		String password= sc.nextLine();
		driverAccount.add(password);
		
		System.out.println("Driver mobile number: ");
		String mobilenumber= sc.nextLine();
		driverAccount.add(mobilenumber);
		
		System.out.println("Driver License: ");
		String license= sc.nextLine();
		driverAccount.add(license);
		
		System.out.println("Driver nation id: ");
		String nationalid= sc.nextLine();
		driverAccount.add(nationalid);
		
		return driverAccount;
	}
}
