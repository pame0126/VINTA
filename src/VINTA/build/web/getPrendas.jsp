<%-- 
    Document   : getPrendas
    Created on : 08/04/2018, 04:33:42 PM
    Author     : Wifuss
--%>

<%@page import="Modelo.tienda.Prenda"%>
<%@page import="Modelo.tienda.db.DBPrenda"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<title>Productos</title>
<link rel="stylesheet"  href="css/login.css"> 
</head>
<body>
   
 <br/>

<form action="MostrarTodasPrendas" method="post">

        <form action="/VINTA/MostrarTodasPrendas" method="post">
            
            <select name="opciones">
                <option values ="1">Todas</option>
                <option values ="2">Ninguna</option>
            </select>
            <input type="submit" value="Seleccionar"/>
            
     <% 
                ArrayList<Prenda> lista = (ArrayList<Prenda>) request.getAttribute("lista");
            %>
            <select name="Coleccion" >
                <% for(Prenda p: lista){ 
                %>
                <option values =<%= p.getIdString() %>> <%= p.getFotos().get(0) %> </option>
                <%
                    }
                %>
            </select>
            
        </form>
    
</body>
</html>
