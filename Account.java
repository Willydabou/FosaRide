public class Account {
	protected
		String UserName, eMail, password, mobileNumber;
		// boolean accountStatus = false;
		Registration registration;
		Ride ride = new Ride();
	
	public
		void performRegistration() {
			// @SuppressWarnings("unused")
			// List<String> stringAccount = new ArrayList<>();
			//stringAccount = registration.AccountRegistration();
		}
	
		void setUserName(String U) { this.UserName=U; }
		void setEmail(String em) { this.eMail=em; }
		void setPassword(String ps) { this.password=ps; }
		void setMobile(String mb) { this.mobileNumber=mb; }
		
		String getUserName() { return UserName; }	
}
