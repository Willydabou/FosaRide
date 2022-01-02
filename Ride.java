import java.util.ArrayList;
import java.util.List;

public class Ride {
	List<Driver> driverList = new ArrayList<>();
	
	private
		String Source;
		String Destination;
		int Price;
		int passengerNumber;
		User user;
		Driver driver;
	
	public
		void setSource(String s) { this.Source=s; }
		void setDestination(String d) { this.Destination=d; }
		void setPrice(int p) { this.Price=p; }
		void setPassengerNumber(int numberP) { this.passengerNumber=numberP; }
		
		void notifyDriver(List<Driver> listDriver) {
			for(int i=0; i<listDriver.size(); i++) {
				for(int j=0; j<listDriver.get(i).getArea().size(); j++) {
					if(this.Source.equals(listDriver.get(i).getArea().get(j))) {
						System.out.println(listDriver.get(i).getUserName()+" is avalaible ride from "+this.Source+" to "+this.Destination);
					}
				}
			}
		}
		
		
		String getSource() { return this.Source; }
		String getDestination() { return this.Destination; }
		int getPrice() { return this.Price; }
		int getPassengerNumber() { return this.passengerNumber; }
}
