package ictgradschool.web.lab10.examples.example02;

import ictgradschool.web.lab10.User.User;
import ictgradschool.web.lab10.utilities.HtmlHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Really basic servlet which creates session attributes
 */
public class SessionsExampleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println(HtmlHelper.getHtmlPagePreamble("Web Lab 10 Examples - Sessions"));

        //TODOne - if attributes exist, add the appropriate first name, last name, city and country
//        if(request.getSession().getAttribute("fname")!=null && request.getSession().getAttribute("lname")!=null && request.getSession().getAttribute("city")!=null && request.getSession().getAttribute("country")!=null){
        User nUser = (User)request.getSession().getAttribute("nUser");

        if(nUser!=null){

            out.println("hi there "+nUser.getUfName()+" "+nUser.getUlName()+" from "+nUser.getuCity()+", "+nUser.getuCountry());
//            out.println("Welcome " + request.getSession().getAttribute("fname") + " " + request.getSession().getAttribute("lname") + " from " + request.getSession().getAttribute("city") + ", " + request.getSession().getAttribute("country"));
        } else {
            out.print("not all fields exist, please go away");
        }
//        out.println("Welcome FNAME LNAME from CITY, COUNTRY");

        out.println("<a href=\"index.html\">HOME</a><br>");

        // Print out a form allowing users to enter new session attributes
        out.println("<form action=\"Sessions\" method=\"GET\">");
        out.println("<p>Create a new session attribute:</p>");
        out.println("<label for=\"inputAttrName\">New attribute name:</label>");
        out.println("<input type=\"text\" id=\"inputAttrName\" name=\"attrName\" />");
        out.println("<br>");
        out.println("<label for=\"inputAttrValue\">New value:</label>");
        out.println("<input type=\"text\" id=\"inputAttrValue\" name=\"attrValue\" />");
        out.println("<br>");
        out.println("<input type=\"hidden\" name=\"option\" value=\"create\" />");
        out.println("<input type=\"submit\"/>");
        out.println("</form>");

        // Print out a form allowing users to see the values of existing session attributes
        out.println("<form action=\"Sessions\" method=\"GET\">");
        out.println("<p>Read an existing session attribute:</p>");
        out.println("<label for=\"readAttrName\">Existing attribute name:</label>");
        out.println("<input type=\"text\" id=\"readAttrName\" name=\"attrName\" />");
        out.println("<br>");
        out.println("<input type=\"hidden\" name=\"option\" value=\"read\" />");
        out.println("<input type=\"submit\"/>");
        out.println("</form>");

        String option = request.getParameter("option");

        // If the user wants to add something to the session, do that now and output the result.
        if (option.equals("create")) {

            // Get the values from the form
            String attrName = request.getParameter("attrName");
            String attrValue = request.getParameter("attrValue");

            System.out.println("Values from user: (name=" + attrName + ", value=" + attrValue + ")");

            // Add a session attribute with the given name / value
            request.getSession().setAttribute(attrName, attrValue);

            // Print out the result to the output
            out.println("<p>Added attribute to session:</p>");
            out.println("<p><strong>Name:</strong> <em>" +attrName + "</em></p>");
            out.println("<p><strong>Value:</strong> <em>" + request.getSession().getAttribute(attrName) + "</em></p>");

            // This line prints to the server's console, not the client.
            System.out.println("Added to session (name=" + attrName + ", value=" + request.getSession().getAttribute(attrName) + ")");
        }

        // If the user wants to read an attribute, do that now and output the result
        else if (option.equals("read")) {

            // Get the values from the form
            String attrName = request.getParameter("attrName");

            // Read the value
            Object attrValue = request.getSession().getAttribute(attrName);

            // Print out the result
            if (attrValue != null) {

                System.out.println("Read attribute (name=" + attrName + ", value=" + attrValue + ")");

                out.println("<p>Found existing session attribute:</p>");
                out.println("<p><strong>Name:</strong> <em>" + attrName + "</em></p>");
                out.println("<p><strong>Value:</strong> <em>" + attrValue + "</em></p>");
            }

            else {

                System.out.println("Session attribute named " + attrName + " not found.");

                out.println("<p>Couldn't find a session attribute named <em>" + attrName + "</em> :(</p>");
            }

        }

        // Footer stuff
        out.println(HtmlHelper.getHtmlPageFooter());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
