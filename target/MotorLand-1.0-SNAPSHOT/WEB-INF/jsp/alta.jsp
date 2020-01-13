<%-- 
    Document   : alta
    Created on : 13-ene-2020, 12:27:31
    Author     : julut
--%>

<!-- Le indicamos que vamos a utilizar tags -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Motor</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Mediante este link habilitamos el uso de bootstrap en nuestra vista -->
    </head>
    <body>
        <div class="row">
            <div class="col-6, offset-3"><!-- Le damos un ancho de 6 y lo centramos dejando 3 vacios a la izquierda -->
                <h1>Ingrese un nuevo motor en la BBDD</h1>
                <br>
        <form:form>
            <form:errors path="*" element="div" className="alert alert-danger"></form:errors><!-- Con esto mostraremos si existe algún error cuando redirijamos al formulario desde el post del AltaController -->
            <form:label path="modelo">Modelo</form:label><!-- Asociamos la label al input correspondiente -->
            <form:input path="modelo" cssClass="form-control"/><!-- asociamos el campo modelo del motor, al pasar el objeto como lo hemos hecho en el controlador no hay que especificar en el form el nombre del objeto -->
            <form:label path="fabricante">Fabricante</form:label>
            <form:input path="fabricante" cssClass="form-control"/>
            <form:label path="potencia">Potencia</form:label>
            <form:input path="potencia" cssClass="form-control"/>
            <form:label path="peso">Peso</form:label>
            <form:input path="peso" cssClass="form-control"/>
            <form:label path="cantidad">Cantidad</form:label>
            <form:input path="cantidad" cssClass="form-control"/>
            <br>
            <button types="submit" class="btn btn-primary">Enviar</button><!-- Envíamos de vuelta los datos por post al AltaController -->
        </form:form>
    </body>
</html>
