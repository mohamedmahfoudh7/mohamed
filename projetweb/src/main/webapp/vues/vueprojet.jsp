<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Projet</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="navbar.html"%>
<br><br>

<br><br>
<table class="table table-hover">
<tr>
 <th>Cahier Charge</th><th>ID</th><th>Code</th><th>Description</th><th>Encadrant Responsable</th><th>Stagiare</th><th>Action</th>
</tr>
<c:forEach items="${liste}" var="p">
<tr>
<td>
	<a  href="src/main/webapp/imagesdata/Capture1_1673270530651" download> telecharger pdf</a>
</td>	
<td>${p.id}</td>
<td>${p.code}</td>
<td>${p.description }</td>
<td>ID : ${p.encadrant.id} | Nom : ${p.encadrant.nom} | Prenom : ${p.encadrant.prenom}</td>
<td> ID : ${p.stagiare.id } | nom : ${p.stagiare.nom } | prenom : ${p.stagiare.prenom }</td>

<td><a href="/projet/supprimerprojet/${p.id}"onclick="return confirm('voulez vous supprimer ce Projet ${p.code}?')"
 class="btn btn-danger"><span class="fa fa-trash"></span></a>
 <a href="/projet/modifierprojet/${p.id}" class="btn btn-warning">
 <span class="fa fa-edit"></span></a>
 
</td>
</tr>
</c:forEach>
</table>
</body>
</html>