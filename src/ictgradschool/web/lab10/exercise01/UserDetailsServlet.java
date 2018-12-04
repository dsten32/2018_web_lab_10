package ictgradschool.web.lab10.exercise01;

import ictgradschool.web.lab10.utilities.HtmlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Header stuff
        out.println(HtmlHelper.getHtmlPagePreamble("Web Lab 10 - Sessions"));

        out.println("<a href=\"index.html\">HOME</a><br>");

        out.println("<h3>Data entered: </h3>");
        //TODO - add the firstName, lastName, city and country  that were entered into the form to the list below
        //TODO - add the parameters from the form to session attributes
        out.println("<ul>");
        out.println("<li>First Name: </li>");
        out.println("<li>Last Name: </li>");
        out.println("<li>Country: </li>");
        out.println("<li>City: </li>");
        out.println("</ul>");

        out.println(HtmlHelper.getHtmlPageFooter());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process POST requests the same as GET requests
        doGet(request, response);
    }
}
