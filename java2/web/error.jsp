<%-- 
    Document   : error
    Created on : 09-oct-2017, 11:04:00
    Author     : user
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="utils.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color: green">Caja de seguridad</h1>
       <h3 style="color:red">Se ha producido un error, tendras que empezar desde el principio.</h3>
       <c:set var = "nivel" scope = "session" value = "0000"/>

    </body>
</html>
