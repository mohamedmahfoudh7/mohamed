<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire Stagiare</title>
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
crossorigin="anonymous">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
crossorigin="anonymous"></script>
</script>
</head>
<body>
<%@include file="navbar.html"%>
<br>
<br>
<br>
<c:if test="${message!=null}">
<div class="alert alert-success" role="alert">
<c:out value="${message}"></c:out>
${stagiare=null}
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
<div class="card-header">
<h2>Ajouter Stagiare</h2>
</div>
<div class="card-body">
<form action="/stagiare/sauvgarderstagiare" method=post
enctype="multipart/form-data">
<div class="mb-3 mt-3">
<label for="nom" class="form-label">Nom:</label>
 <input type=text class="form-control" id="nom" name="nom"
 value="${stagiare.nom}">
</div>
<div class="mb-3">
<label for="prenom" class="form-label">Prenom:</label>
 <input type="text" class="form-control" id="prenom" name="prenom"
value="${stagiare.prenom}">
</div>
<div class="mb-3">
<label for="etablissement" class="form-label">Etablissement Universitaire:</label>
 <input type="text" class="form-control" id="etablissement"name="etablissement" value="${stagiare.etablissement}">
</div>

</div>
<div class="mb-3">
<label for="email" class="form-label">Email:</label>
 <input type="text" class="form-control" id="email"name="email" value="${stagiare.email}">
</div>


<div class="mb-3">
<label for="numero" class="form-label">Numero:</label>
 <input type="number" class="form-control" id="numero"name="numero" value="${stagiare.numero}">
</div>


<div class="mb-3">
<label for="projet" class="form-label">Projet :</label>
 <select name="projet" required>
<option selected hidden value="">choisir projet ici</option>
<c:forEach items="${projets}" var="p">
<option value="${p.id}"<c:if test="${stagiare.projet.id==p.id}">selected="true"</c:if>>${p.code}</option>
</c:forEach>
</select>
</div>

</div>







<input type=hidden name=id value="${stagiare.id}">
 <button type="submit" class="btn btn-primary">Save</button>
 </form>
</div>
</div>
</div></body></html>