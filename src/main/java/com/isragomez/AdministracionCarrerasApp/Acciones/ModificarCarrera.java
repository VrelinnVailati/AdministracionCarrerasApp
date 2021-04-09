package com.isragomez.AdministracionCarrerasApp.Acciones;

import com.isragomez.AdministracionCarrerasApp.CarreraDAO;
import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificarCarrera", value = "/ModificarCarrera")
public class ModificarCarrera extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("id"));
        boolean error = Boolean.parseBoolean(StringUtils.defaultString(request.getParameter("error"), "false"));
        CarreraDAO carreraDAO = new CarreraDAO();
        Carrera carrera = null;

        try {
            carrera = carreraDAO.obtenerCarrera(ID);
        } catch (SQLException throwables) {
            carrera = new Carrera();
            throwables.printStackTrace();
        }

        request.setAttribute("carrera", carrera);
        request.setAttribute("error", error);
        request.getRequestDispatcher("/views/ModificarCarrera.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(StringUtils.defaultString(request.getParameter("id")));
        String nombreCarrera = StringUtils.defaultString(request.getParameter("nombreCarrera"));
        int duracion = Integer.parseInt(StringUtils.defaultString(request.getParameter("duracion"), "0"));

        if(nombreCarrera.length() < 5 || duracion == 0) {
            response.sendRedirect(request.getContextPath() + "/ModificarCarrera?error=true&id=" + ID);
        } else {
            //Guardamos la información en la base de datos
            CarreraDAO carreraDAO = new CarreraDAO();
            Carrera nuevaCarrera = new Carrera(ID, nombreCarrera, duracion);

            try {
                carreraDAO.actualizarCarrera(nuevaCarrera);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            //Se redirecciona a la página de éxito en el registro
            request.getRequestDispatcher("/views/CarreraActualizada.jsp").forward(request, response);
        }
    }
}
