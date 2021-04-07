package com.isragomez.AdministracionCarrerasApp.Acciones;

import com.isragomez.AdministracionCarrerasApp.CarreraDAO;
import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class ListarCarreras extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CarreraDAO carreraDAO = new CarreraDAO();

        try {
            ArrayList<Carrera> carreras = carreraDAO.mostrarCarreras();
            request.setAttribute("carreras", carreras);
        } catch (SQLException ex) {
            System.out.println("No se pudieron mostrar las carreras");
            ex.printStackTrace();
            request.setAttribute("carreras", new ArrayList<Carrera>());
        }

        request.getRequestDispatcher("/views/ListarCarreras.jsp").forward(request, response);
    }

    public void destroy() {
    }
}