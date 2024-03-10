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
import phoenix.model.User;
import java.io.IOException;

/*
    Control Servlet to register a user.
    Reads and handles POST request data.
    Redirects user to login form if passed.
    Redirects user to register form if failed.
    This servlet handles all types of users includng normal users, level 1 staff members, level 2 staff members and administrator.
*/
@WebServlet(name = "registration",urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;
    
    /* Constructors */
    //Calls the default constructor of super class.
    public RegistrationServlet() {
        super(); 
    }

    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a UserDataAccess Object..
        Reads data from POST request parameters.
        Checks the role of the User object.
        Creates a LevelOne or LevelTwo or User object based on role.
        Inserts user to user table.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDataAccess userDao = new UserDataAccess();
        int numRows;
        if(request.getParameter("register") != null) {
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String address=request.getParameter("address");
            String userRole=request.getParameter("role");
            String dob=request.getParameter("dob");

            switch (userRole) {
                case "1" ->                     {
                        StaffMember staffMember = new LevelOne(name, dob, email, address, password, "Level 1");
                        numRows = userDao.insertNewStaffMember(staffMember);
                    }
                case "2" ->                     {
                        StaffMember staffMember = new LevelTwo(name, dob, email, address, password, "Level 2");
                        numRows = userDao.insertNewStaffMember(staffMember);
                    }
                default -> {
                        User user = new User(name, dob, email, address, password, "User");
                        numRows = userDao.insertNewUser(user);
                }
            }
            if(numRows > 0) {
                response.sendRedirect("login.jsp");
            }
            else {
                response.sendRedirect("registration.jsp");
            }
        }
    }

}
