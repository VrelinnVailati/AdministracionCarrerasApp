package com.isragomez.AdministracionCarrerasApp.Acciones;

import com.isragomez.AdministracionCarrerasApp.CarreraDAO;
import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class MostrarInfoCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarreraDAO carreraDAO = new CarreraDAO();
        int ID = Integer.parseInt(request.getParameter("id"));

        try {
            Carrera carrera = carreraDAO.obtenerCarrera(ID);
            request.setAttribute("carrera", carrera);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            request.setAttribute("carrera", new Carrera());
        }

        request.getRequestDispatcher("/views/InfoCarrera.jsp").forward(request, response);
    }
}
