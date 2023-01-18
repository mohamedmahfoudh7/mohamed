<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Encadrant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="navbar.html"%>
<br><br>

<br><br>
<div >
<table class="table table-hover" border="5">
<tr>
 <th>ID</th><th>Nom</th><th>Prenom</th><th>Action</th>
</tr>
<c:forEach items="${liste_encadrant}" var="e">
<tr>

		
<td>${e.id}</td>
<td>${e.nom}</td>
<td>${e.prenom }</td>
<!--  
<td>
<select name="projet" required>
<option selected hidden value="">click pour voir projets</option>
<c:forEach items="${liste_projet}" var="p">
<option>${p.code}</option>
</c:forEach>
</select>
</td>
-->
<td><a href="/encadrant/supprimerencadrant/${e.id}"onclick="return confirm('voulez vous supprimer ce Encadrant ${p.nom} ${p.prenom }?')"
 class="btn btn-danger"><span class="fa fa-trash"></span></a>
 <a href="/encadrant/modifierencadrant/${e.id}" class="btn btn-warning">
 <span class="fa fa-edit"></span></a>
 
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>