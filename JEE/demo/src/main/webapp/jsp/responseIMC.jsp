<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Response secret</title>
</head>
<body>
  <p>Cc je pèse : <%= request.getAttribute("kg") %></p>
  <p>Et je taille : <%= request.getAttribute("taille") %></p>
  <p>mon imc est de : <%= request.getAttribute("imc") %></p>
  <p>Et je suis en : <%= request.getAttribute("responseIMC") %></p>
</body>
</html>