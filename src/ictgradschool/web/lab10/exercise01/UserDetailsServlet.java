package ictgradschool.web.lab10.exercise01;

import ictgradschool.web.lab10.User.User;
import ictgradschool.web.lab10.utilities.HtmlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String country=request.getParameter("country");
        String city=request.getParameter("city");

        User nUser = new User(fname,lname,country,city);

        HttpSession session=request.getSession(true);

        session.setAttribute("nUser",nUser);

//        session.setAttribute("fname",fname);
//        session.setAttribute("lname",lname);
//        session.setAttribute("country",country);
//        session.setAttribute("city",city);

        Cookie cfname = new Cookie("fname",fname);
        Cookie clname = new Cookie("lname",lname);
        Cookie ccountry = new Cookie("country",country);
        Cookie ccity = new Cookie("city",city);

        response.addCookie(cfname);
        response.addCookie(clname);
        response.addCookie(ccountry);
        response.addCookie(ccity);


        // Header stuff
        out.println(HtmlHelper.getHtmlPagePreamble("Web Lab 10 - Sessions"));

        out.println("<a href=\"index.html\">HOME</a><br>");

        out.println("<h3>Data entered: </h3>");
        //TODOne - add the firstName, lastName, city and country  that were entered into the form to the list below
        //TODOne - add the parameters from the form to session attributes
        out.println("<ul>");
        out.println("<li>First Name: "+nUser.getUfName()+"</li>");
        out.println("<li>Last Name: "+nUser.getUlName()+"</li>");
        out.println("<li>Country: "+nUser.getuCountry()+"</li>");
        out.println("<li>City: "+nUser.getuCity()+"</li>");
        out.println("</ul>");



        out.println(HtmlHelper.getHtmlPageFooter());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process POST requests the same as GET requests
        doGet(request, response);
    }
}
