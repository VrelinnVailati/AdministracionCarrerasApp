package com.isragomez.AdministracionCarrerasApp;

import com.isragomez.AdministracionCarrerasApp.Modelos.Carrera;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CarreraDAO {
    private static final String SQL_INSERT = "insert into carrera(nombreCarrera, duracion) values (?, ?)";
    private static final String SQL_UPDATE = "update carrera set nombreCarrera = ?, duracion = ? where id = ?";
    private static final String SQL_DELETE = "delete from carrera where id = ?";
    private static final String SQL_READ = "select * from carrera where id = ?";
    private static final String SQL_READ_ALL = "select * from carrera";

    private Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Dotenv dotenv = Dotenv.load();
        String usuario = "root";
        String pword = dotenv.get("DB_PASSWORD");
        String url = "jdbc:mysql://localhost:3306/carreras?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, usuario, pword);
    }

    public void crearCarrera(Carrera carrera) throws SQLException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(CarreraDAO.class.getName()).severe("Error: " + e);
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, carrera.getNombreCarrera());
            preparedStatement.setInt(2, carrera.getDuracion());
            preparedStatement.executeUpdate();
        } finally {
            if(preparedStatement != null) preparedStatement.close();
            conexion.close();
        }
    }

    public void actualizarCarrera(Carrera carrera) throws SQLException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, carrera.getNombreCarrera());
            preparedStatement.setInt(2, carrera.getDuracion());
            preparedStatement.setInt(3, carrera.getId());
            preparedStatement.executeUpdate();
        } finally {
            if(preparedStatement != null) preparedStatement.close();
            if(conexion != null) conexion.close();
        }
    }

    public void borrarCarrera(Carrera carrera) throws SQLException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexion.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, carrera.getId());
            preparedStatement.executeUpdate();
        } finally {
            if(preparedStatement != null) preparedStatement.close();
            if(conexion != null) conexion.close();
        }
    }

    public ArrayList<Carrera> mostrarCarreras() throws SQLException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = conexion.prepareStatement(SQL_READ_ALL);
            resultSet = preparedStatement.executeQuery();
            ArrayList<Carrera> carreras = obtenerCarreras(resultSet);
            if(carreras.size() > 0) {
                return carreras;
            } else {
                return null;
            }
        } finally {
            if(resultSet != null) resultSet.close();
            if(preparedStatement != null) preparedStatement.close();
            if(conexion != null) conexion.close();
        }
    }

    public Carrera obtenerCarrera(int id) throws SQLException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();
        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }

        PreparedStatement enunciado = null;
        ResultSet resultado = null;
        Carrera carrera = null;
        try {
            enunciado = conexion.prepareStatement(SQL_READ);
            enunciado.setInt(1, id);
            resultado = enunciado.executeQuery();
            carrera = obtenerCarrera(resultado);
            return carrera;
        } finally {
            if(resultado != null) resultado.close();
            if(enunciado != null) enunciado.close();
            if(conexion != null) conexion.close();
        }
    }

    private ArrayList<Carrera> obtenerCarreras(ResultSet rs) throws SQLException {
        ArrayList<Carrera> carreras = new ArrayList();

        while (rs.next()) {
            Carrera c = new Carrera();
            c.setId(rs.getInt("id"));
            c.setNombreCarrera(rs.getString("nombreCarrera"));
            c.setDuracion(rs.getInt("duracion"));
            carreras.add(c);
        }

        return carreras;
    }

    private Carrera obtenerCarrera(ResultSet rs) throws SQLException {
        Carrera carrera = new Carrera();
        if(rs.next()) {
            carrera.setId(rs.getInt("id"));
            carrera.setNombreCarrera(rs.getString("nombreCarrera"));
            carrera.setDuracion(rs.getInt("duracion"));
        }

        return carrera;
    }
}
