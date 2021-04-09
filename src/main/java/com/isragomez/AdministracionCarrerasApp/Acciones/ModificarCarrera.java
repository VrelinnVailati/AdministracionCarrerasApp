package com.isragomez.AdministracionCarrerasApp.Acciones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModificarCarrera", value = "/ModificarCarrera")
public class ModificarCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", ID);
        request.getRequestDispatcher("/views/ModificarCarrera.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
