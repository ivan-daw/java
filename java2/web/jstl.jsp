<%-- 
    Document   : jstl
    Created on : 17-oct-2017, 8:37:00
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="utils.Constantes"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: green">Caja de seguridad</h1>
        <h3 style="color:blue">
            <c:if test="${not empty mensajeInfo}">
                <c:out value = "${mensajeInfo}"/>
                </c:if>
        </h3>

        <h3 style="color:purple">
            <c:if test="${nivel eq 1111}">
                Has conseguido pasar todos los niveles! La caja esta abierta.
            </c:if>
        </h3>
    </body>
</html>
