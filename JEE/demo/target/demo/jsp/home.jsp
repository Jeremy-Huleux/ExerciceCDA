<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Home</title>
  <%= request.getAttribute("name") %>

</head>
<body>
  <h1>Home</h1>
  <form method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password">
    <button type="submit">Envoi</button>
  </form>
</body>
</html>