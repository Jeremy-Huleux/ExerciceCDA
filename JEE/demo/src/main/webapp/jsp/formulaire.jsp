<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        nav {
            background-color: #444;
            overflow: hidden;
        }
        nav a {
            float: left;
            display: block;
            color: #fff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin-bottom: 20px;
        }
        form input, form button {
            padding: 10px;
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Formulaire Page</h1>
    </header>
    <nav>
        <a href="home">Home</a>
        <a href="formulaire">Formulaire</a>
    </nav>
    <div class="container">

        <table>
            <thead>
                <tr>
                    <th>idUtilisateur</th>
                    <th>nom</th>
                    <th>prenom</th>
                    <th>pseudo</th>
                    <th>mdp</th>
                    <th>dateInscription</th>
                    <th>dateModif</th>
                    <th>jeton</th>
                    <th>bio</th>
                    <th>idPreferenceUtilisateur</th>
                    <th>idMedia</th>
                    <th>idRole</th>
                    <th>email</th>
                </tr>
            </thead>
            <tbody id="itemList">
                  <c:if test="${not empty utilisateurs}">
                    <c:forEach items="${utilisateurs}" var="utilisateur">
                        <form action="formulaire" method="post">
                            <tr>
                                <td><input type="hidden" name="idUtilisateur" value="${utilisateur.idUtilisateur}" >${utilisateur.idUtilisateur}</td>
                                <td>${utilisateur.nom}</td>
                                <td>${utilisateur.prenom}</td>
                                <td>${utilisateur.pseudo}</td>
                                <td>${utilisateur.mdp}</td>
                                <td>${utilisateur.dateInscription}</td>
                                <td>${utilisateur.dateModif}</td>
                                <td>${utilisateur.jeton}</td>
                                <td>${utilisateur.biographie}</td>
                                <td>${utilisateur.idPreferenceUtilisateur}</td>
                                <td>${utilisateur.idMedia}</td>
                                <td>${utilisateur.idRole}</td>
                                <td>${utilisateur.email}</td>
                                <td>
                                    <button type="submit">Modifier</button>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>

    </div>
</body>
</html>