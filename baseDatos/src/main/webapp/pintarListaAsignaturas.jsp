<%-- 
    Document   : pintarListaAsignaturas
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
                          

            function cargarAsignatura(id, nombre, curso, ciclo) {
                document.getElementById("idasignatura").value = id;
                document.getElementById("nombre").value = nombre;
                document.getElementById("curso").value = curso;
                document.getElementById("ciclo").value = ciclo;

            

            }
            
            function myFunction(id){
                this.id=id;
    document.getElementById("op").value = id;
   
}
</script>

    </head>
    <body>
        <h1>Asignaturas</h1>
        pruebaCTE: <%= Constantes.PRUEBA%> <br>
        <table border="1">
            <c:forEach items="${asignaturas}" var="asignatura">  
                <tr>
                    <td>
                        <input type="button" value="cargar ${asignatura.id}" 
                               onclick="cargarAsignatura('${asignatura.id}',
                                               '${asignatura.nombre}',
                                               '${asignatura.curso}',
                               '${asignatura.ciclo}');"/>
                    </td> 
                    <td>
                        ${asignatura.nombre}
                    </td>

                    <td>
                        ${asignatura.curso}
                    </td>

                    <td>
                        ${asignatura.ciclo}
                        </td>       
                    </tr>


            </c:forEach> 

        </table>
        <form action="asignaturas" name="formulario2" method="get" >
            <input type="hidden" name ="op" id="op" value="test"/>
            <input type="hidden" name="id" id="idasignatura" />
            <input type="text" name="nombre" id="nombre" size="12"/>
            <input type="text" name="curso" id="curso" size="12"/>
            <input type="text" name="ciclo" id="ciclo" size="12"/>
            <br>
            <!--servelets alumnos.java-->
            <button id="listar" onclick="myFunction(id)">Listar</button>
            <button id="insertar" onclick="return myFunction(id)">Insert</button>
            <button id="update" onclick="myFunction(id)">Update</button>
            <button id="eliminar" onclick="return myFunction(id)">Delete</button>                 

        </form>


    </body>
</html>
