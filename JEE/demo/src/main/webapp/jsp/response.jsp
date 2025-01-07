<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Response secret</title>
</head>
<body>
  <p>Cc je suis : <%= request.getAttribute("username") %></p>
  <p>Et mon mot de passe secret est : <%= request.getAttribute("password") %></p>
  <form method="post">
    <p>taille en m<input type="number" step="0.1" name="taille"></p><br>
    <p>poids en kg <input type="number" step="0.1" name="kg"></p>
    <button type="submit">Calculer mon imc de gros</button>
  </form>
</body>
</html>