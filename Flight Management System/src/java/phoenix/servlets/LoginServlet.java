package phoenix.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import phoenix.daos.UserDataAccess;
import phoenix.model.User;
import java.io.IOException;

/*
    Control Servlet to login in a user.
    Reads and handles POST request data.
    Redirects user to appropirate dashboard if passed.
    Redirects user to login form if failed.
    This servlet handles all types of users includng normal users, level 1 staff members, level 2 staff members and administrator.
*/
@WebServlet(name="login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    /* Instance fields */
    //serialVersionUID to ensure proper deserialization.
    private static final long serialVersionUID = 1L;

    /* Constructors */
    //Calls the default constructor of super class.
    public LoginServlet() {
        super();

    }
    /*
        Instance methods
    */
    //doPost method to handle POST requests.
    /*
        Instantiates a UserDataAccess Object.
        Creates a User object.
        Reads data from POST request parameters and populates User object.
        Adds the email to the user's session for tracking the user.
        Checks the role of the User object.
        Adds the role to the user's session.
        Inserts login details to the database and redirects user to appropirate database.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDataAccess userDao = new UserDataAccess();
        int userRole;
        if(request.getParameter("login")!=null) {
            //Reads data from POST request and populates User 
            User user = new User();
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            user.setEmail(email);
            user.setPassword(password);
            userRole = userDao.checkUserRole(user);
            String ip=request.getRemoteAddr();
            //Retrives a session object from doPost parameter 'request'.
            HttpSession session=request.getSession();
            //Adds user e-mail to session.
            session.setAttribute("email", email);
            //Checks role
            switch (userRole) {
                //If Level 1 Staff
                case 1 -> {
                    //Adds role to session
                    session.setAttribute("role", "Level 1");
                    userDao.insertLoginDetailsRecord(email, "Level 1", ip);
                    response.sendRedirect("staff_dashboard.jsp");
                }
                //If Level 2 Staff
                case 2 -> {
                    //Adds role to session
                    session.setAttribute("role", "Level 2");
                    userDao.insertLoginDetailsRecord(email, "Level 2", ip);
                    response.sendRedirect("staff_dashboard.jsp");
                }
                //If Normal user
                case 3 -> {
                    //Adds role to session
                    session.setAttribute("role", "User");
                    userDao.insertLoginDetailsRecord(email, "User", ip);
                    response.sendRedirect("user_dashboard.jsp");
                }
                //If administrator
                case 4 -> {
                    //Adds role to session
                    session.setAttribute("role", "Admin");
                    userDao.insertLoginDetailsRecord(email, "Admin", ip);
                    response.sendRedirect("admin_dashboard.jsp");
                }
                //If invalid data
                default -> response.sendRedirect("login.jsp");
            }
        }
    }

}
