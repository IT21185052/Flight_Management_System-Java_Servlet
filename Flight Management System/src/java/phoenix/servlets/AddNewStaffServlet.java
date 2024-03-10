package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phoenix.daos.UserDataAccess;
import phoenix.model.LevelOne;
import phoenix.model.LevelTwo;
import phoenix.model.StaffMember;
import java.io.IOException;

/*
    Control Servlet to add a new user record with a role of 'Level 1' or 'Level 2'.
    Reads and handles POST request data.
    Redirects administrator to dashboard if passed.
    Redirects administrator to form if failed.
*/
@WebServlet(name="addNewStaff",urlPatterns = {"/addNewStaff"})
public class AddNewStaffServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;
       
    /* Constructors */
    //Calls the default constructor of super class.
    public AddNewStaffServlet() {
        super();
    }
    
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a UserDataAccess Object.
        Reads data from POST request parameters.
        Checks the role of the data entry.
        Creates a LevelOne object if role is 'Level 1'.
        Creates a LevelTwo object if role is 'Level 2'.
        Inserts new staff member. Account status is set to 'Pending'.
        Redirects administrator to dashboard if passed.
        Redirects administrator to form if failed.
    */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDataAccess userDao = new UserDataAccess();
		int numRows = 0;
		if(request.getParameter("register") != null) {
                        //Reads POST data.
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String address=request.getParameter("address");
			String role=request.getParameter("role");
			String dob=request.getParameter("dob");
			
                        //Roles is 'Level 1'
			if(role.equals("1")) {
                            StaffMember staffMember = new LevelOne(name, dob, email, address, password, "Level 1");
                            numRows = userDao.insertNewStaffMember(staffMember);
			}
                        //Role is 'Level 2'
			else if(role.equals("2")) {
                            StaffMember staffMember = new LevelTwo(name, dob, email, address, password, "Level 2");
                            numRows = userDao.insertNewStaffMember(staffMember);
			}
                        //Checks if operation is successful.
			if(numRows > 0) {
                            response.sendRedirect("admin_dashboard.jsp");
			}
			else {
                            response.sendRedirect("add_new_Staff_member.jsp");
			}
		}
	}

}
