package com.isragomez.AdministracionCarrerasApp.Acciones;

import com.isragomez.AdministracionCarrerasApp.CarreraDAO;
import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AgregarCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean error = Boolean.parseBoolean(StringUtils.defaultString(request.getParameter("error"), "false"));

        request.setAttribute("error", error);
        request.getRequestDispatcher("/views/AgregarCarrera.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCarrera = StringUtils.defaultString(request.getParameter("nombreCarrera"));
        int duracion = Integer.parseInt(StringUtils.defaultString(request.getParameter("duracion"), "0"));

        System.out.println(String.format("Nombre: %s. Duración: %d", nombreCarrera, duracion));
        if(nombreCarrera.length() < 5 || duracion == 0) {
            response.sendRedirect(request.getContextPath() + "/AgregarCarrera?error=true");
        } else {
            //Guardamos la información en la base de datos
            CarreraDAO carreraDAO = new CarreraDAO();
            Carrera nuevaCarrera = new Carrera(nombreCarrera, duracion);

            try {
                carreraDAO.crearCarrera(nuevaCarrera);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //Se redirecciona a la página de éxito en el registro
            request.getRequestDispatcher("/views/CarreraAgregada.jsp").forward(request, response);
        }
    }
}
