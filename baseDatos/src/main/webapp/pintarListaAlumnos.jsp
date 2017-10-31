<%-- 
    Document   : pintarListaAlumnos
    Created on : Oct 28, 2017, 8:02:42 PM
    Author     : oscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.Constantes" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            
            function cargarAlumno(id,nombre,fecha,mayor){
               document.getElementById("nombre").value=nombre;
              document.getElementById("idalumno").value=id;
                
            }
            
            function cargarNotas(id,nombre,curso,ciclo){
                 document.getElementById("nombrenot").value=nombre;
              document.getElementById("idnot").value=id;
                document.getElementById("nombrenot").value=curso;
                  document.getElementById("nombrenot").value=ciclo;
            }
            </script>
    </head>
    <body>
        <h1>ALUMNOS</h1>
        pruebaCTE: <%= Constantes.PRUEBA %> <br>
        <table border="1">
        <c:forEach items="${alumnos}" var="alumno">  
            <tr>
                <td>
                    <input type="button" value="cargar ${alumno.id}" 
                           onclick="cargarAlumno('${alumno.id}',
                           '${alumno.nombre}',
                                       '<fmt:formatDate value="${alumno.fecha_nacimiento}" pattern="dd-MM-yyyy"/>',
                                       ${alumno.mayor_edad});"/>
                </td> 
                <td>
                    ${alumno.nombre}
                </td>
   
                <td>
                    <fmt:formatDate value="${alumno.fecha_nacimiento}" pattern="dd-MM-yyyy"/>
                </td>

                <td>
                    <input type="checkbox" <c:if test="${alumno.mayor_edad}" >checked</c:if> />
                </td>
            </tr>
        
          
        </c:forEach> 
            
                    <c:forEach items="${asignaturas}" var="asignaturas">  
            <tr>
                <td>
                    <input type="button" value="cargar ${asignaturas.id}" 
                           onclick="cargarAlumno('${asignaturas.id}',
                           '${asignaturas.nombre}','${asignaturas.curso}',
                           '${asignaturas.ciclo}'
                                     "/>
                </td> 
                <td>
                    ${asignaturas.nombre}
                </td>
                                <td>
                    ${asignaturas.curso}
                </td>
                                <td>
                    ${asignaturas.ciclo}
                </td>
            </tr>
        
          
        </c:forEach> 
            
            </table>
        <form target="alumnos?op=insertar" >
            <input type="hidden" id="idalumno" />
        <input type="text" id="nombre" size="12"/>
         <input type="text" id="fecha" size="12"/>
          <input type="text" id="nombre" size="12"/>
          <br>
            <input type="text" id="nombrenot" size="12"/>
         <input type="text" id="ciclo" size="12"/>
          <input type="text" id="curso" size="12"/>
        </form>
    </body>
</html>
