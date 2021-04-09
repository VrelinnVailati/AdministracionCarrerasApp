<%@ page import="com.isragomez.AdministracionCarrerasApp.Modelos.Carrera" %><%--
  Created by IntelliJ IDEA.
  User: Vi Vailati
  Date: 4/8/2021
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <title>Modificar Carrera</title>
    </head>
    <body>
        <% boolean error = Boolean.parseBoolean(request.getAttribute("error").toString()); %>
        <% Carrera carrera = (Carrera) request.getAttribute("carrera"); %>
        <div class="container-fluid">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a href="${pageContext.request.contextPath}" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span class="fs-4"><i class="fas fa-arrow-left"></i></span>
                </a>
                <h3 class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">Modificar Programa Educativo</h3>
            </header>
        </div>

        <div class="container">
            <p style="visibility: <%= error ? "visible" : "hidden" %>; color: red;">Errores en los datos, introduzca nuevamente</p>
            <form method="post">
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" disabled name="id" id="id" value="<%= carrera.getId() %>">
                    <label for="id">ID</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="nombreCarrera" id="nombreCarrera" value="<%= carrera.getNombreCarrera() %>" placeholder="Nombre del Programa Educativo">
                    <label for="nombreCarrera">Nombre del Programa Educativo</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="number" class="form-control" name="duracion" value="<%= carrera.getDuracion() %>" id="duracion" placeholder="4">
                    <label for="duracion">Duración</label>
                </div>
                <button type="submit" id="btnAdd" class="btn btn-success">Actualizar</button>
            </form>
        </div>
    </body>
</html>
