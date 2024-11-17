<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Catégories</title>

</head>
<body>

    <div id="formCategorie">
        <form action="Categorie.do" method="post">
            <table>
                <tr>
                    <td>Code :</td>
                    <td><input type="text" name="codeCat"></td>
                </tr>
                <tr>
                    <td>Libelle :</td>
                    <td><input type="text" name="libelle"></td>
                </tr>
                <tr>
                    <td>Description :</td>
                    <td><input type="text" name="description"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="AjouterCat">
                        <input type="submit" name="action" value="ModifierCat">
                        <input type="submit" name="action" value="RechercherCat">
                    </td>
                </tr>
            </table>
        </form>
    </div>


    <div>
        <table>
            <tr>
                <th>Code</th>
                <th>Libelle</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${categories}" var="ct">
                <tr>
                    <td>${ct.code}</td>
                    <td>${ct.libelle}</td>
                    <td>${ct.description}</td>
                    <td>
                        <form action="Categorie.do" method="post" style="display:inline;">
                            <input type="hidden" name="codeToDeleteCat" value="${ct.code}">
                            <input type="submit" name="action" value="SupprimerCat">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <nav>
        <a href="Produit.jsp">Go to Produit Form</a>
    </nav>
</body>
</html>