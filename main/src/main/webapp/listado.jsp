<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Personas</title>
    </head>
    <body>
        <table border="1">
            <caption>Listado de Personas</caption>
            <tr>
                <th>Id Persona</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Teléfono</th>
            </tr>
            
            <c:forEach var="persona" items="${personas}" varStatus="status">
                <tr>
                    <td><c:out value="${persona.idPersona}"/></td>
                    <td><c:out value="${persona.nombre}"/></td>
                    <td><c:out value="${persona.apellido}"/></td>
                    <td><c:out value="${persona.email}"/></td>
                    <td><c:out value="${persona.telefono}"/></td>
                    
                </tr>
            </c:forEach>
            
            
        </table>

    </body>
</html>