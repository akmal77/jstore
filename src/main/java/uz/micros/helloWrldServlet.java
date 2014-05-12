package uz.micros;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/", name="Hello Borya")
public class helloWrldServlet extends HttpServlet {
    //private static final Long serialVersionUID = 1L

/*    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().println("Krutoy proekt!!!");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Krutoy proekt!!!" + req.getServletContext().getServerInfo());
    }
}