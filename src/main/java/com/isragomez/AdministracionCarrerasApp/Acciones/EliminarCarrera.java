package com.isragomez.AdministracionCarrerasApp.Acciones;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EliminarCarrera", value = "/EliminarCarrera")
public class EliminarCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
