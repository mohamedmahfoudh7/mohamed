<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire Projet</title>
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
${projet=null}
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
<div class="card-header">
<h2>Ajouter Projet</h2>
</div>
<div class="card-body">
<form action="/projet/sauvgarderprojet" method=post
enctype="multipart/form-data">
<div class="mb-3 mt-3">
<label for="code" class="form-label">Code:</label>
 <input type=text class="form-control" id="code" name="code"
 value="${projet.code}">
</div>
<div class="mb-3">
<label for="description" class="form-label">Description:</label>
 <input type="text" class="form-control" id="description" name="description"
value="${projet.description}">
</div>

<div class="mb-3">
<label for="encadrant" class="form-label">Encadrant :</label>
 <select name="encadrant" required>
<option selected hidden value="">choisir encadrant</option>
<c:forEach items="${encadrants}" var="e">
<option value="${e.id}"<c:if test="${projet.encadrant.id==e.id}">selected="true"</c:if>>${e.nom} ${e.prenom} (ID : ${e.id})</option>
</c:forEach>
</select>
</div>
<div class="mb-3">
 <input type=hidden name=photo value="${projet.photo}">
<label class="form-label">Photos</label> <input type="file"
name="file" accept="application/pdf" class=form-control />
 </div>
<input type=hidden name=id value="${projet.id}">
 <button type="submit" class="btn btn-primary">Save</button>
 </form>
</div>
</div>
</div></body></html>