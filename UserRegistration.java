import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration implements Registration {
	Scanner sc = new Scanner(System.in);
	@Override
	public List<String> AccountRegistration() {
		@SuppressWarnings("unused")
		User user = new User();
		System.out.println("==========User Registration==========");
		
		List<String> userAccount = new ArrayList<>();
		System.out.println("userName: ");
		String username= sc.nextLine();
		userAccount.add(username);
		
		System.out.println("User id: ");
		String userid=sc.nextLine();
		userAccount.add(userid);
		
		System.out.println("User email: ");
		String email=sc.nextLine();
		userAccount.add(email);
		
		System.out.println("User Password: ");
		String password= sc.nextLine();
		userAccount.add(password);
		
		System.out.println("User mobile number: ");
		String mobilenumber= sc.nextLine();
		userAccount.add(mobilenumber);
		
		//user.setUserName(username);user.setUserID(userid);user.setEmail(email);
		//user.setPassword(password);user.setMobile(mobilenumber);
		
		
		
		return userAccount;
	}

}
