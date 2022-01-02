
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRegistration implements Registration{
	Scanner sc = new Scanner(System.in);
	@Override
	public List<String> AccountRegistration() {
		@SuppressWarnings("unused")
		Admin admin = new Admin();
		
		List<String> AdminAccount = new ArrayList<>();
		System.out.println(" Admin userName: ");
		String username= sc.nextLine();
		AdminAccount.add(username);

		System.out.println("Admin Password: ");
		String password= sc.nextLine();
		AdminAccount.add(password);
		
		return AdminAccount;
	}
}