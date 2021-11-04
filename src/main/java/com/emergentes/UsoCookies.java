package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsoCookies", urlPatterns = {"/UsoCookies"})
public class UsoCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsoCookies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsoCookies at " + request.getContextPath() + "</h1>");
            //Mostrar Cookie
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                String name = c.getName();
                String value = c.getValue();
                out.println(name + " = " + value + "<br>");
            }
            //Adicionar cookie
            String name = request.getParameter("nombre");
            if (name != null && name.length() > 0) {
                String value = request.getParameter("valor");
                Cookie c = new Cookie(name, value);
                c.setMaxAge(30);
                response.addCookie(c);
                out.println("nombre = " + name + "<br>valor = " + value);
                out.println("<br>Cookie ha sido Agregado...");
            }
            out.println("<center><a href='Menu'>Volver al Menu Principal</a></center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
