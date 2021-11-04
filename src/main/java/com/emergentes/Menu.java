package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1 style='color:Tomato;'>Main Menu </h1></center>");
            out.println("<a href='InfoCabeceras'>1. Crear Servelet Infocabeceras</a><br>");
            out.println("<a href='UsoCookies'>2. Crear Servelet Uso Cookies</a><br>");
            out.println("<a href='UsoSession'>3. Crear Servelet Uso Session</a><br>");
//Calendar fecha = new GregorianCalendar(); 
            //int ano = fecha. get(Calendar.YEAR);
            out.println("<br><center><h5 style='color:MediumSeaGreen';>" + anio + " Copyright © by Josuard Company. All Rights Reserved</h5></center>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
