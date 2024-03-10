package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phoenix.daos.UserDataAccess;
import phoenix.model.User;
import java.io.IOException;

/*
    Control Servlet to update a user profile.
    Reads and handles POST request data.
    Redirects users to profile page if passed.
    This servlet handles all types of users includng normal users, level 1 staff members, level 2 staff members and administrator.
*/
@WebServlet(name="UpdateProfile",urlPatterns = {"/UpdateProfile"})
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UpdateProfileServlet() {
        super();
    }	
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a UserDataAccess Object.
        Reads data from POST request parameters.
        Intantiates a User object, populates object with read data.
        Performs update on user table records.
        Checks success of operation.
        Redirects staff member to profile page if passed.
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDataAccess userDao = new UserDataAccess();
        int numRows;
        if(request.getParameter("update") != null) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            String role = request.getParameter("role");
            String dob = request.getParameter("dob");
            User user = new User(name, dob, email, address, password, role);
            user.setId(Integer.valueOf(request.getParameter("id")));
            numRows = userDao.updateUserRecords(user);
            if(numRows > 0) {
                response.sendRedirect("profile.jsp");
            }
        }
    }

}
