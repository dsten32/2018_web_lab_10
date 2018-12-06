package ictgradschool.web.lab10.exercise04;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HitCounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        Cookie hit = new Cookie("hits","0");
//        Cookie hits=null;
//        if(cookies==null){
//            hits=new Cookie("hits","10");
////        }
//        PrintWriter out = resp.getWriter();
//        out.print("here");

        if ("true".equalsIgnoreCase(req.getParameter("removeCookie"))) {



            //TODO - add code here to delete the 'hits' cookie

//            if(cookies!=null){
                    for (Cookie cookie:cookies) {
//                    if(cookie.getName().equals("hits")){
                        cookie.setMaxAge(0);
//                    }
                }
//            }

        } else {

            //TODO - add code here to get the value stored in the 'hits' cookie then increase it by 1 and update the cookie


// if(cookies!=null){
//                hits=new Cookie("hits","0");

            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("hits")){
                    hit = cookie;
                    break;
//                        int counter = Integer.parseInt(cookie.getValue());
//                        counter++;
//                        cookie.setValue(String.valueOf(counter));
                }
            }
//            }
            if(hit==null){
                hit = new Cookie("hits","1");
            } else {
                int counter = Integer.parseInt(hit.getValue());
                counter++;
                hit.setValue(String.valueOf(counter));

            }

        }
        resp.addCookie(hit);
        //TODO - use the response object's send redirect method to refresh the page

        resp.sendRedirect("hit-counter.html");

    }
}
