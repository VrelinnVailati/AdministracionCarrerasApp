<%@ page import="java.util.ArrayList" %>
<%@ page import="com.isragomez.AdministracionCarrerasApp.Modelos.Carrera" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Carreras</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    </head>
    <body>
        <% ArrayList<Carrera> carreras = (ArrayList<Carrera>)request.getAttribute("carreras"); %>
        <div class="container-fluid">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a style="cursor: default;" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                    <span class="fs-4">Programas Educativos</span>
            </header>
        </div>

        <div class="container-fluid">
            <table class="table table-dark table-striped table-borderless">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre de la Carrera</th>
                        <th scope="col">Duración</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Carrera carrera : carreras) { %>
                    <tr>
                        <% int cID = carrera.getId(); %>
                        <th scope="row"><a href="${pageContext.request.contextPath}/carrera?id=<%= cID %>"><span class="badge bg-primary"> <%= cID %> </span></a></th>
                        <td><%= carrera.getNombreCarrera() %></td>
                        <td><%= carrera.getDuracion() %></td>
                        <td><button class="btn btn-outline-light">Actualizar</button></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <div style="text-align: center;">
                <a href="${pageContext.request.contextPath}/AgregarCarrera" class="btn btn-success">Agregar Programa Educativo</a>
            </div>
        </div>
    </body>
</html>