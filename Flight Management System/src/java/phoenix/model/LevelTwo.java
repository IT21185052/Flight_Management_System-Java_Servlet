package phoenix.model;

/*
    Class without member definitions that inherit from StaffMember. Created for sementic purposes.
    Also adds scalability to the website.
*/
public class LevelTwo extends StaffMember {

	public LevelTwo() {
		super();
		
	}

	public LevelTwo(String name, String dob, String email, String address, String password, String role) {
		super(name, dob, email, address, password, role);
		
	}
	
	
        @Override
	public void viewFlightDetails() {
		
	}
	
	public void viewTicketDetails() {
		
	}
}
