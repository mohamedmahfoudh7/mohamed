<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.html"%>
<br><br><br><center>
<h3>List Affectation Projet Technologie</h3>
</center>

 


<div class="row">
<div class="col-2"></div>
    <div class="col-4">
<form action="/affectation/technologieParprojet" method="get">

<div class="mb-3">
<select class="form-select" name="projet" onchange="submit()">
<option selected hidden >${projet}</option>
<option value="0">Toutes les projets</option>
<c:forEach items="${liste_projet}" var="cc">
<option value="${cc.id}">${cc.code}</option>
</c:forEach>
</select>
</div>
</form>
</div>

</div>

<table class="table table-hover">
<tr>
 <th>Id</th><th>nom de Technologie</th>
</tr>

<c:forEach items="${technologie}" var="p">
<tr>
<td>${p.id}</td>
<td>${p.nom}</td>


<td><a href="/formation/desaffecterformation/${formateurr.id}/${p.id}"
 class="btn btn-danger">Desaffecter</a>
</tr>
</c:forEach>

</table>
</body>
</html>