package breweryfinder.servlets;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet (
	name = "helloWorld",
	urlPatterns = {"/helloWorld"}
)

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().print("<h1>Hello World!</h1>");
    }

}
