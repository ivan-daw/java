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
                
                 <c:out value = "${nivel}"/>
            </c:if>
        </h3>
        <%--
        
        <h3 style="color:red">
            <c:if test="${not empty mensajeError}">
                <c:out value = "${mensajeError}"/>
                </c:if>
        </h3>

          <c:set var = "info" scope = "session" value = "${mensajeInfo}"/>
          <c:set var = "error" scope = "session" value = "${mensajeError}"/>
          <c:set var = "caja" scope = "session" value = "${nivel}"/>
  
          
       <c:choose>
               <c:when test="${nivel eq 1111}">
Se abrio la caja
              </c:when>
            <c:when test = "${not empty info}"> 
                  <c:out value="${info}" />
            </c:when>
     
             <c:when test="${not empty error}">
                    <c:out value="${mensajeError}" />
          </c:when>
          
       </c:choose>
       
       <h3 style="color:red">
    
       </h3>
        --%>
        <%--
              
          <c:set var="nivel2" value="${sessionScope.nivel}" scope="session" />
          <c:out value="${sessionScope.nivel2}" />
        --%>
    </body>
</html>
