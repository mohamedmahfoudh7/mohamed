<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire Technologie</title>
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
${technologie=null}
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
<div class="card-header">
<h2>Ajouter Technologie</h2>
</div>
<div class="card-body">
<form action="/technologie/sauvgardertechnologie" method=post>
<div class="mb-3 mt-3">
<label for="nom" class="form-label">Nom:</label>
 <input type=text class="form-control" id="nom" name="nom" value="${technologie.nom}">
</div>

<!--  
<div class="mb-3">
<label for="Categorie" class="form-label">Projet:</label>
 <select name="categorie" required>
<option selected hidden value="">choisir un projet</option>
<c:forEach items="${projets}" var="p">
<option value=${p.id}
 <c:if test="${encadrant.projet.id==p.id}">selected="true"</c:if>>${p.nom} </option>
</c:forEach>
</select>
</div>

-->

<input type=hidden name=id value="${technologie.id}">
 <button type="submit" class="btn btn-primary">Save</button>
 </form>
</div>
</div>
</div></body></html>