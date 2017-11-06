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
                          

            function cargarAlumno(id, nombre, fecha, mayor) {
                document.getElementById("idalumno").value = id;
                document.getElementById("nombre").value = nombre;
                document.getElementById("fecha").value = fecha;
                document.getElementById("mayor").value = mayor;

            

            }
            
            function myFunction(id){
                this.id=id;
    document.getElementById("op").value = id;
   
}
</script>

    </head>
    <body>
        <h1>ALUMNOS</h1>
        pruebaCTE: <%= Constantes.PRUEBA%> <br>
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

        </table>
        <form action="alumnos" name="formulario1" method="get" >
            <input type="hidden" name ="op" id="op" value="test"/>
            <input type="hidden" name="id" id="idalumno" />
            <input type="text" name="nombre" id="nombre" size="12"/>
            <input type="text" name="fecha" id="fecha" size="12"/>
            <input type="text" name="mayor" id="mayor" size="12"/>
            <br>
            <!--servelets alumnos.java-->
            <button id="listar" onclick="myFunction(id)">Listar</button>
            <button id="insertar" onclick="return myFunction(id)">Insert</button>
            <button id="update" onclick="myFunction(id)">Update</button>
            <button id="eliminar" onclick="return myFunction(id)">Delete</button>                 

        </form>

        <script>
            
          //  function myFunction(id) {
            //    this.id=id;
     //document.formulario1.action = "alumnos?op="+id;
     // document.getElementById("formulario1").action ="alumnos?op="+id;
    // if (id=="update"){
      //    document.getElementById("idalumno").value = id;
        //        document.getElementById("nombre").value = nombre;
          //      document.getElementById("fecha").value = fecha;
            //    document.getElementById("mayor").value = mayor;
                //arr = {nombre,fecha,mayor};
              //   formulario1.action = "alumnos?op="+id+"&obj="+arr;
    // } else {
    // formulario1.action = "alumnos?op="+id;
     //}
   // document.formulario1.submit();

}
        </script>
    </body>
</html>
