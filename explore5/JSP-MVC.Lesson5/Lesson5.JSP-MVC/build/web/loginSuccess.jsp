<%-- 
    Document   : loginSuccess
    Created on : Nov 20, 2014, 6:06:13 PM
    Author     : jarfrf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="MVC.Loginbean"%>  
  
<p>You are successfully logged in!</p>  
<%  
Loginbean bean=(Loginbean)request.getAttribute("bean");  
out.print("Welcome, "+bean.getName());  
%>  
