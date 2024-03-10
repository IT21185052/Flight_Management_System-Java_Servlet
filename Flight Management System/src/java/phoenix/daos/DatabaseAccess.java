package phoenix.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Class which sets up a connection with the database server.
    Consists of a single method to return a Connection object.
*/
public class DatabaseAccess {
    
    /*
        Instance method which sets up a connection with a mysql database server.
        Acts as the Data Acess Object. 
    */
	public Connection getMySQLConnection() {
		Connection db = null;
		try {
                        //Creates and instance of the mysql driver and registers that instance with the DriverManager.
			Class.forName("com.mysql.jdbc.Driver");

                        String url = "jdbc:mysql://localhost:3306/phoenix_flight_db";
                        String username = "root";
                        String password = "";
                        //Specifies the database URL, username and password to access the database.
                        //Retrives a Connection object.
			db = DriverManager.getConnection(url, username, password);
		}
		catch(ClassNotFoundException | SQLException e) {
                    //Handles and exceptions
			System.out.println(e.getMessage());
		}
		return db;
	}
}