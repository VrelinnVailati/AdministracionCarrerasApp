<%@ page import="com.isragomez.AdministracionCarrerasApp.Modelos.Carrera" %><%--
  Created by IntelliJ IDEA.
  User: Vi Vailati
  Date: 4/6/2021
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <title>Información del Programa Educativo</title>
    </head>
    <body>
        <% Carrera carrera = (Carrera)request.getAttribute("carrera"); %>
        <div class="container-fluid">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="${pageContext.request.contextPath}" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span class="fs-4"><i class="fas fa-arrow-left"></i></span>
                </a>
                <h3 class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">Información del Programa Educativo</h3>
            </header>

            <table class="table table-striped">
                <tr>
                    <td>ID</td>
                    <td><%= carrera.getId() %></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><%= carrera.getNombreCarrera() %></td>
                </tr>
                <tr>
                    <td>Duración</td>
                    <td><%= carrera.getDuracion() %></td>
                </tr>
            </table>

            <div style="text-align: center;">
                <button class="btn btn-outline-primary">Modificar Programa Educativo</button>
                <button class="btn btn-danger">Eliminar Programa Educativo</button>
            </div>
        </div>
    </body>
</html>
