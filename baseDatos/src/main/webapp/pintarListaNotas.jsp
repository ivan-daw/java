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
                          
                          function cargarAlumno(id, nombre) {
                                              document.getElementById("idalumno").value = id;
                document.getElementById("nombreasig").value = nombre;
                          }

            function cargarAsignatura(id, nombre) {
                document.getElementById("idasignatura").value = id;
                document.getElementById("nombreal").value = nombre;
              
  function cargarNota(id, nombre) {
         document.getElementById("nota").value = nota;
  }
            

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
                          <input type="button" value="cargar ${alumno.id}" 
                               onclick="cargarAsignatura('${alumno.id}',
                                               '${alumno.nombre}'
                                             "/>
                        
                    </td>
                    <td>
                        ${alumno.nombre}
                    </td>
                    
                    <td>
                        
                        <input type="button" value="cargar ${asignatura.id}" 
                               onclick="cargarAsignatura('${asignatura.id}',
                                               '${asignatura.nombre}'
                                               "/>
                    </td> 
                    <td>
                        ${asignatura.nombre}
                    </td>
    <input type="button" value="cargar ${nota.nota}" 
                               onclick="cargarAsignatura('${nota.nota}'
                                               
                                               "/>
    
    <td>
        ${nota.nota}
    </td>
                    </tr>


            </c:forEach> 

        </table>
        <form action="notas" name="formulario3" method="get" >
            <input type="hidden" name ="op" id="op" value="test"/>
            <input type="hidden" name="id" id="idasignatura" />
              <input type="hidden" name="id" id="idalumno" />
            <input type="text" name="nombrereal" id="nombreal" size="12"/>
                  <input type="text" name="nombreasig" id="nombreasig" size="12"/>
            <input type="text" name="nota" id="nota" size="12"/>
            <br>
            <!--servelets alumnos.java-->
            <button id="listar" onclick="myFunction(id)">Listar</button>
            <button id="insertar" onclick="return myFunction(id)">Insert</button>
            <button id="update" onclick="myFunction(id)">Update</button>
            <button id="eliminar" onclick="return myFunction(id)">Delete</button>                 

        </form>


    </body>
</html>
