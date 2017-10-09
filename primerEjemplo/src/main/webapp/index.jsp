<%-- 
    Document   : index
    Created on : Oct 3, 2017, 11:04:40 AM
    Author     : ivan
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World en JSP!</h1>
        <%
            
            Map<String, String[]> parameters = request.getParameterMap();
            for (String parameter : parameters.keySet()) {

                String[] values = parameters.get(parameter);
                //out.println(StringEscapeUtils.escapeHtml4(values[0]));
        %>
        <h1>
            <% 
                out.println("<h1 style=color:"+parameter+";>"+values[0]+"</h1>");
            %>
        </h1>
        <%  }                      
        %>
            
    </body>
</html>
