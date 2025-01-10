<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
        <form id="table">
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
                <tbody >
                    <c:forEach items="${utilisateurs}" var="utilisateur">
                            <tr>
                                <td><input type="hidden" name="idUtilisateur" value="${utilisateur.idUtilisateur}" ><c:out value="${utilisateur.idUtilisateur}" /></td>
                                <td><c:out value="${utilisateur.nom}" /></td>
                                <td><c:out value="${utilisateur.prenom}" /></td>
                                <td><c:out value="${utilisateur.pseudo}" /></td>
                                <td><c:out value="${utilisateur.mdp}" /></td>
                                <td><fmt:formatDate value="${formattedDateInscr_}+${utilisateur.idUtilisateur}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
                                <td><fmt:formatDate value="${formattedDateModif_}+${utilisateur.idUtilisateur}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
                                <td><c:out value="${utilisateur.jeton}" /></td>
                                <td><c:out value="${utilisateur.biographie}" /></td>
                                <td><c:out value="${utilisateur.idPreferenceUtilisateur}" /></td>
                                <td><c:out value="${utilisateur.idMedia}" /></td>
                                <td><c:out value="${utilisateur.idRole}" /></td>
                                <td><c:out value="${utilisateur.email}" /></td>
                                <td>
                                    <button type="submit" id="modif_${utilisateur.idUtilisateur}">Modifier</button>
                                    <button type="submit" id="suppr_${utilisateur.idUtilisateur}">Supprimer</button>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>