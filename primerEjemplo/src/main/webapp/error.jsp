<%-- 
    Document   : error
    Created on : Oct 9, 2017, 11:04:07 AM
    Author     : ivan
--%>

<%@page import="daw.ivan.primerejemplo.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de errores</h1>
            <h2>
        <%
            out.println(request.getAttribute(Constantes.ERROR));
            %></h2>
    </body>
</html>
