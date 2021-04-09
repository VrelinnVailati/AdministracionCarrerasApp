package com.isragomez.AdministracionCarrerasApp.Acciones;

import com.isragomez.AdministracionCarrerasApp.CarreraDAO;
import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

public class EliminarCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(StringUtils.defaultString(request.getParameter("id")));

        CarreraDAO carreraDAO = new CarreraDAO();
        try {
            carreraDAO.borrarCarrera(new Carrera(ID));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("/views/CarreraEliminada.jsp").forward(request, response);
    }
}
