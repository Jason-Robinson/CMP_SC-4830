<%-- 
    Document   : dataOutput
    Created on : Nov 20, 2014, 6:20:16 PM
    Author     : jarfrf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MVC.Loginbean"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cool Stuff</title>
    </head>
    <body>
        <%  
            Loginbean bean=(Loginbean)request.getAttribute("bean");  
            out.print("Is this what you entered?: "+bean.getName());  
        %>  
    </body>
</html>
