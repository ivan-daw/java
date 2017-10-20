<%-- 
    Document   : index
    Created on : 03-oct-2017, 11:00:53
    Author     : user
        if("contrasea.equals.rgP("PASS");"
        {
            f.jspsig
        }
        else{ f.error.jsp

if (nvm1.equal(rcpcm1)
--%>



<%@page import="utils.Constantes"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1><%
    if(null == session.getAttribute(Constantes.NIVEL)){
          out.println("No vueles pajaro empieza por el nivel 1");
    }
    else {
            //session.getAttribute != null
           if (request.getSession().getAttribute(Constantes.NIVEL).equals(1111))
               {
           out.println("Genial has abierto la caja");
           
        } else {
               out.println("No pasaste todos los niveles");
           }
    }
            %></h1>
    </body>
</html>
