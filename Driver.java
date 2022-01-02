import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver extends Account {
	Scanner sc = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	@SuppressWarnings("unused")
	private 
		String driverID, driverLicense, nationalID;
		Registration registration = new DriverRegistration();
		List<String> FavoriteArea = new ArrayList<>();
		List<Short> userRating = new ArrayList<>();
		boolean AccountStatus = false;
		boolean flag = false ;  //true if driver currently in a Ride
	public
	
	static List<Ride> RequestRides = new ArrayList<>();
	
		Driver() {}
	
		Driver(String anID, String aLicense, String anId){
			this.driverID = anID;
			this.driverLicense = aLicense;
			this.nationalID = anId;
		}
		
		void setFlag(boolean fl) { this.flag=fl; }
		
	public void listAllFavoriteAreaRides () {				//	List only in the favorite Areas;
		System.out.println("\nNo  \tSOURCE\t\tDESTINATION");
		for(int i=0; i<RequestRides.size(); i++) {
			if(this.FavoriteArea.equals(RequestRides.get(i).getSource()))
				System.out.println((i+1)+"  \t" + RequestRides.get(i).getSource()+"\t\t" + RequestRides.get(i).getDestination());
		}
	}
	
	public void listAllRequestRides () {					// 	List all Ride requested by users;
		System.out.println("\nNo  \tSOURCE\t\tDESTINATION");
		for(int i=0; i<RequestRides.size(); i++) {
			System.out.println((i+1)+"  \t" + RequestRides.get(i).getSource()+"\t\t" + RequestRides.get(i).getDestination());
		}
	}
	
	public void listAllRatings () {					// 	List all Ratings by user;
		System.out.println("Ride " + "\t\tRatings");
		for(int i=0; i<userRating.size(); i++) {
			System.out.println((i+1) + "\t\t" + userRating.get(i));
		}
	}
	
	public float AverageRating () {
		float totalRating = 0;
		for(int i=0; i<userRating.size(); i++) {
			totalRating += userRating.get(i);
		}
		float avg = (totalRating / userRating.size());
		return avg;
	}
	
	public void performRegistration() {
			List<String> driverAccount = new ArrayList<>();
			driverAccount = registration.AccountRegistration();
			this.UserName=driverAccount.get(0);
			this.driverID=driverAccount.get(1);
			this.eMail=driverAccount.get(2);
			this.password=driverAccount.get(3);
			this.mobileNumber=driverAccount.get(4);
			this.driverLicense=driverAccount.get(5);
			this.nationalID=driverAccount.get(6);
		
			this.AccountStatus = false;
	}
		
	public void setAccountStatus (boolean aStatus) {
		this.AccountStatus = aStatus;
	}
	
	public boolean getStatus () {
		return this.AccountStatus;
	}
		// void setRide(Ride rd) { rides.add(rd); }
		
	void addFavoriteArea() {										// 4) Add Favorite Area;
		System.out.println("Add Source: ");
		String SourceArea = sc.nextLine();
		FavoriteArea.add(SourceArea);
	}
		
		void listRides (List<Ride> ride) {							// 5) List all rides;
			System.out.println("\nSOURCE\t\tDESTINATION");
			for(int i=0; i<ride.size(); i++) {
				if(this.FavoriteArea.equals(ride.get(i).getSource()))
					System.out.println(ride.get(i).getSource()+"\t\t"+ride.get(i).getDestination());
			}
		}
		
		Ride suggestPrice () {										// 5) Suggesting a price;
			
			listAllFavoriteAreaRides();
			if (RequestRides.size() == 0) {
				System.err.println("NO PENDING RIDES");
				return null;
			}
			else {
				System.out.println("Choose Ride No: ");
				int no = in.nextInt();
				
				System.out.println("Give your offer: ");
				int offer = in.nextInt();
				
				Ride aRide = new Ride();
				aRide = RequestRides.get(no - 1);
				
				aRide.setPrice(offer);					// Setting the offer;
				
				RequestRides.set(no - 1, aRide);
				
				return aRide;
			}
		}
	
		String getDriverID() { return driverID; }
		String getLicense() { return driverLicense; }
		String getNationalID() { return nationalID; }
		List<String> getArea(){ return FavoriteArea; }
		List<Short> getRatings() {return userRating;}
}
