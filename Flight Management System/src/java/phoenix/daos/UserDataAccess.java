package phoenix.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoenix.model.StaffMember;
import phoenix.model.User;

/*
    Class to handle all database CRUD operations related to objects of User and it's children classes.
    Helps provide a layer of abstraction at the servlet level.
*/
public class UserDataAccess {
        
        //Holds connection to a MySQL database.
	private final Connection databaseConnection;
        
        //Constructor to initialise Connection object
	public UserDataAccess() {
            this.databaseConnection = new DatabaseAccess().getMySQLConnection();
        }
        
        /*
            Method to insert a record to user table with a role of 'Level 1' or 'Level 2'.
            Requires a fully initialised object of StaffMember or it's children.
            Returns the number of rows affected.
        */
	public int insertNewStaffMember(StaffMember staff) {
            //Number of rows affected.
            int numRows = 0;
            try {
                //Query to insert a new user record with a role of 'Level 1' or 'Level 2'.
                String query="insert into user_table (name, email, password, dob, address, role, status) values (?, ?, ?, ?, ?, ?, ?);";
                //PreparedStatement object created from query.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets the PreparedStatement with member fields of the StaffMember object.
                pStatement.setString(1, staff.getName());
                pStatement.setString(2, staff.getEmail());
                pStatement.setString(3, staff.getPassword());
                pStatement.setString(4, staff.getDob());
                pStatement.setString(5, staff.getAddress());
                pStatement.setString(6, staff.getRole());
                pStatement.setString(7, staff.getAccStatus());
                //Executes the insert query returning the number of affected rows.
                numRows = pStatement.executeUpdate();	
            }
            catch(SQLException e) {
                //Exception handling
                System.out.println(e.getMessage());
            }
            //Returns the number of rows affected.
            return numRows;
	}
	
        /*
            Method to insert a record to user table with a role of 'User'.
            Requires a fully initialised object of User.
            Returns the number of rows affected.
        */
	public int insertNewUser(User user) {
            //Number of rows affected.
            int numRows = 0;
            try {
                //Query to insert a new user record with a role of 'User'.
                String query="insert into user_table (name, email, password, dob, address, role) values (?, ?, ?, ?, ?, ?);";
                //PreparedStatement object created from query.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets the PreparedStatement with member fields of the User object.
                pStatement.setString(1, user.getName());
                pStatement.setString(2, user.getEmail());
                pStatement.setString(3, user.getPassword());
                pStatement.setString(4, user.getDob());
                pStatement.setString(5, user.getAddress());
                pStatement.setString(6, user.getRole());
                //Executes the insert query returning the number of affected rows.
                numRows = pStatement.executeUpdate();
            }
            catch(SQLException e) {
                //Handles exceptions.
                System.out.println(e.getMessage());
            }
            //Returns the number of rows affected.
            return numRows;
	}
	
	/*
            Method to check the role attribute of the user table.
            Accepts a User object as a parameter with initialised email and password fields.
            Returns an integer representing the role of the user.
        */
	public int checkUserRole(User user) {
            //Holds the integer representing role of the user.
            int roleIndex = 0;
            try {
                //Query to retrieve a user record from the email and password attributes.
                String query="select * from user_table where email = ? and password = ?;";
                //PreparedStatement made from the query.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets the PreparedStatement with email and password members of the User object.
                pStatement.setString(1, user.getEmail());
                pStatement.setString(2,user.getPassword());
                //Excecutes the query statement and retrives the results into a ResultSet object.
                ResultSet result = pStatement.executeQuery();
                //If a record is retrieved, proceeds to check the user role.
                if(result.next()) {
                    //Gets the status and role from the user record.
                    String status =result.getString("status");
                    String role = result.getString("role");
                    //Assigns a value to the roleIndex that identifies the respective user role.
                    if(status.equals("Activated")) {
                        switch (role) {
                            case "Level 1":
                                roleIndex = 1;
                                break;
                            case "Level 2":
                                roleIndex = 2;
                                break;
                            case "User":
                                roleIndex = 3;
                                break;
                            case "Admin":
                                roleIndex = 4;
                                break;
                            default:
                                roleIndex = 0;
                        }

                    }

                }
            }
            catch(SQLException e) {
                //Handles Exceptions
                System.out.println(e.getMessage());
            }
            //Returns the integer identifying the user role.
            return roleIndex;
	}
	
        /*
            Method to retrieve all staff members from the user table.
            Returns a List of StaffMember objects. 
        */
	public List<StaffMember> getStaffMembers(){
            List<StaffMember> staffMemberList = new ArrayList();
            try {
                //Query to retrive all staff members from user table.
                String query="select * from user_table where role=? or role=? order by id desc;";
                //PreparedStatement object created from query.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets values to PreparedStatement object using roles identifying staff members ('Level 1' and 'Level 2').
                pStatement.setString(1, "Level 1");
                pStatement.setString(2, "Level 2");
                //Exectutes query statement returning results to a ResultSet object.
                ResultSet result = pStatement.executeQuery();
                //Iterates through the results set.
                while(result.next()) {
                    //Creates a new StaffMember object for each record.
                    StaffMember staffMember = new StaffMember();
                    //Fully initialises the StaffMember object with data from the ResultSet.
                    staffMember.setId(result.getInt("id"));
                    staffMember.setName(result.getString("name"));
                    staffMember.setEmail(result.getString("email"));
                    staffMember.setAccStatus(result.getString("status"));
                    staffMember.setAddress(result.getString("address"));
                    staffMember.setDob(result.getString("dob"));
                    staffMember.setPassword(result.getString("password"));
                    staffMember.setRole(result.getString("role"));
                    //Adds the StaffMember object to the staffMemberList.
                    staffMemberList.add(staffMember);
                }
            }
            catch(SQLException e) {
                //Handles exceptions.
                System.out.println(e.getMessage());
            }
            //Returns the list of StaffMember objects.
            return staffMemberList;
	}
	
        /*
            Method to set the user_status of a user record to 'Activated'.
            Accepts a StaffMember object with an initialised id member field.
            Returns the number of rows affected.
        */
	public int activateStaffMember(StaffMember staffMember) {
            //number of affected rows.
            int numRows = 0;
            try {
                //Query to update user_status user records.
                String query = "update user_table set status = ? where id = ?;";
                //PreparedStatement created from user records.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets values of PreparedStatement.
                pStatement.setString(1, "Activated");
                pStatement.setInt(2, staffMember.getId());
                //Executes update statement returning number of affected rows.
                numRows = pStatement.executeUpdate();
            }
            catch(SQLException e) {
                //Handles exceptions.
                System.out.println(e.getMessage());
            }
            //returns number of affected row.
            return numRows;
	}
	
        /*
            Method to set the user_status of a user record to 'De-Activated'.
            Accepts a StaffMember object with an initialised id member field.
            Returns the number of rows affected.
        */
	public int deActivateStaffMember(StaffMember staffMember) {
            //number of affected rows.
            int numRows = 0;
            try {
                //Query to update user_status user records.
                String query = "update user_table set status = ? where id = ?;";
                //PreparedStatement created from user records.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets values of PreparedStatement.
                pStatement.setString(1, "De-Activated");
                pStatement.setInt(2, staffMember.getId());
                //Executes update statement returning number of affected rows.
                numRows = pStatement.executeUpdate();
            }
            catch(SQLException e) {
                //Handles exceptions.
                System.out.println(e.getMessage());
            }
            //returns number of affected row.
            return numRows;
	}
	
        /*
            Method to set the user_status of a user record to 'De-Activated'.
            Accepts a StaffMember object with an initialised id member field.
            Returns the number of rows affected.
        */
	public int removeStaffMember(StaffMember staffMember) {
            //number of affected rows.
            int numRows = 0;
            try {
                //Query to update user_status user records.
                String query = "update user_table set status = ? where id = ?;";
                //PreparedStatement created from user records.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets values of PreparedStatement.
                pStatement.setString(1, "Removed");
                pStatement.setInt(2, staffMember.getId());
                //Executes update statement returning number of affected rows.
                numRows = pStatement.executeUpdate();
            }
            catch(SQLException e) {
                //Handles exceptions.
                System.out.println(e.getMessage());
            }
            //returns number of affected row.
            return numRows;
	}
	
        /*
            Method to retrieve all user records of role 'User'.
            Returns a List of User objects.
        */
	public List<User> getUsers(){
            //Holds a list of User objects with role 'User'
            List<User> userList=new ArrayList();
            try {
                //Query to retrieve user records with role 'User'.
                String query="select * from user_table where role=? order by id desc";
                //PreparedStatement object made from query.
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                //Sets values into the PreparedStatement
                pStatement.setString(1, "User");
                //Executes select statement, returning result to ResultSet. 
                ResultSet result = pStatement.executeQuery();
                //Iterrates through ResultSet.
                while(result.next()) {
                    //Creates a new User object per record.
                    User user = new User();
                    //Initialises object members using values retrieved from database.
                    user.setId(result.getInt("id"));
                    user.setName(result.getString("name"));
                    user.setEmail(result.getString("email"));
                    user.setAddress(result.getString("address"));
                    user.setDob(result.getString("dob"));
                    user.setPassword(result.getString("password"));
                    user.setRole(result.getString("role"));
                    user.setAccStatus(result.getString("status"));
                    //Adds the User object to the userList.
                    userList.add(user);
                }
            }
            catch(SQLException e) {
                //Exception handling.
                System.out.println(e.getMessage());
            }
            //Returns the list of User objects.
            return userList;
	}
	
        /*
            Method updates a login detail record identified by the user e-mail.
            If the record doesn't exist, a new record is created.
            Requires the user email, role and IP address as parameters.
            Returns the number of rows affected.
        */
	public int insertLoginDetailsRecord(String email,String role,String ip) {
            int numRows = 0;
            try {
                String query = "update login_details_table set time = now(), ip = ? where email = ?;";
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                pStatement.setString(1, ip);
                pStatement.setString(2, email);
                numRows = pStatement.executeUpdate();

                if(numRows <= 0) {
                    query = "insert into login_details_table values (?, ?, now(), ?);";
                    pStatement = databaseConnection.prepareStatement(query);
                    pStatement.setString(1, email);
                    pStatement.setString(2, role);
                    pStatement.setString(3, ip);				
                    numRows = pStatement.executeUpdate();
                }
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            return numRows;
	}
	
        /*
            Method to retrieve all login_detail records ordered by latest insert/update.
            Returns a ResultSet object containing data retrieved from the database. 
        */
	public ResultSet getAllLoginDetailsRecords() {
            ResultSet result = null;
            try {
                String query="select * from login_details_table order by time desc;";
                PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                result = pStatement.executeQuery();
            }
            catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            return result;
	}
	
        /*
            Method to update a user record.
            Requires a fully initialised User object as a parameter.
            Returns the number of rows affected.
        */
	public int updateUserRecords(User user) {
		int numRows = 0;
		try {
			String query="update user_table set name = ?, email = ?, password = ?, dob =? , address = ?, role = ? where id = ?;";
			PreparedStatement pStatement = databaseConnection.prepareStatement(query);
			pStatement.setString(1, user.getName());
			pStatement.setString(2, user.getEmail());
			pStatement.setString(3, user.getPassword());
			pStatement.setString(4, user.getDob());
			pStatement.setString(5, user.getAddress());
			pStatement.setString(6, user.getRole());
			pStatement.setInt(7, user.getId());
			System.out.println(user.getId());
			numRows = pStatement.executeUpdate();
			
			
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return numRows;
	}
	
        /*
            Retrieves a user record from the database.
            Requires a User object with an intialised id member.
            Returns the object fully intialised with returned data.
        */
	public User getUserRecord(User user) {
		try {
                    String query = "select * from user_table where email=?";
                    PreparedStatement pStatement = databaseConnection.prepareStatement(query);
                    pStatement.setString(1, user.getEmail());
                    ResultSet result = pStatement.executeQuery();
                    if(result.next()) {
                        user.setId(result.getInt("id"));
                        user.setName(result.getString("name"));
                        user.setEmail(result.getString("email"));
                        user.setAddress(result.getString("address"));
                        user.setDob(result.getString("dob"));
                        user.setPassword(result.getString("password"));
                        user.setRole(result.getString("role"));
                        user.setAccStatus(result.getString("status"));
                    }
		}
		catch(SQLException ex) {
                    System.out.println(ex.getMessage());
		}
		return user;
	}
	
}
