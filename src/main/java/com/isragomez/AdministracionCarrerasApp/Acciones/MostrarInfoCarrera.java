package com.isragomez.AdministracionCarrerasApp.Acciones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class MostrarInfoCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/InfoCarrera.jsp").forward(request, response);
    }
}
