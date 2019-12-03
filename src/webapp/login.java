package webapp;

import appLayer.User;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "login")
public class login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //PrintWriter out = response.getWriter();
        //out.println("doPost-version:");
        //out.print("login-name: " + request.getParameter("loginname") + "  Password: " + request.getParameter("password"));

        User userObject = new User();

        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        if (userObject.isValidUserCredentials(request.getParameter("loginname"),request.getParameter("password"))) {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid login and password. Try again");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("login-name" + request.getParameter("loginname") + "Password:" + request.getParameter("password"));
    }
}
