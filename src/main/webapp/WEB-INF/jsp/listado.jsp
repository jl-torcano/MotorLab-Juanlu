<%-- 
    Document   : listado
    Created on : 13-ene-2020, 13:53:51
    Author     : julut
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- En la primera parte del meta vamos a cargar todo lo necesario para la maquetación de la vista -->
        <meta charset="UTF-8" />
        <title>Listado de Motores</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Listado de Motores de MOTORLAND</h1>
                <!-- Creamos la tabla donde vamos a volcar los resultados -->
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Modelo</th>
                            <th>Fabricante</th>
                            <th>Potencia</th>
                            <th>Peso</th>
                            <th>Cantidad</th>
                            <th>Óptimo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Mediante tags creamos un bucle para mostrar los elementos de la lista -->
                        <c:forEach items="${listadoMotores}" var="motor">
                            <tr>
                              <td><c:out value="${motor.modelo}"></c:out></td>
                              <td><c:out value="${motor.fabricante}"></c:out></td>
                              <td><c:out value="${motor.potencia}"></c:out></td>
                              <td><c:out value="${motor.peso}"></c:out></td>
                              <td><c:out value="${motor.cantidad}"></c:out></td>
                              <td><c:choose>
                                      <!-- Mediante tags realizamos la comprobación del Optimo -->
                                     <c:when test="${motor.peso/motor.potencia<10}">SI</c:when>    
                                     <c:otherwise>NO</c:otherwise>
                                  </c:choose>
                            </tr>  
                        </c:forEach>    
                    </tbody>    
                </table>
            </div>
            <p>
                <!-- Enlace a la página de alta -->
                <a href="alta.htm" class="btn btn-primary"><i class="fas fa-plus-square"></i>Añadir Motor!</a>
            </p>
        </div>
    </body>
</html>
