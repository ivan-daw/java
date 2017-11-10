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
        <h1>Notas</h1>
        pruebaCTE: <%= Constantes.PRUEBA%> <br>
 
            



        <form action="notas" name="formulario3" method="get" >
            
                        
                  <select id="selectalumnos" name="selectalumnos">
 <c:forEach items="${alumnos}" var="alumnos">  
  <option value=${alumnos.id}>${alumnos.nombre}</option>
  </c:forEach> 
</select>
            

           
                  <select id="selectasignaturas" name="selectasignaturas">
 <c:forEach items="${asignaturas}" var="asignaturas">  
  <option value=${asignaturas.id}>${asignaturas.nombre}</option>
  </c:forEach> 
</select>
                     <c:forEach items="${notas}" var="notas">  
                <c:out value = "${notas.nota}"/>
               </c:forEach> 
                
            <br>
 
            <input type="hidden" name ="op" id="op" value="test"/>
            <input type="hidden" name="idasig" id="idasignatura" />
              <input type="hidden" name="idalum" id="idalumno" />
           
          NOTA  <input type="text" name="nota" id="nota" size="12"/>
            <br>
            <!--servelets alumnos.java-->
            <button id="ver" onclick="myFunction(id)">Ver</button>
            <button id="listar" onclick="myFunction(id)">Listar</button>
            <button id="insertar" onclick="return myFunction(id)">Insert</button>
            <button id="update" onclick="myFunction(id)">Update</button>
            <button id="eliminar" onclick="return myFunction(id)">Delete</button>                 

        </form>


    </body>
</html>
