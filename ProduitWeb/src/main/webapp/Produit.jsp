<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Gestion des produits</title>

</head>
<body>
    <div id="formProduit">
        <form action="controleur.do" method="post">
            <table>
                <tr>
                    <td>Code :</td>
                    <td><input type="text" name="code"></td>
                </tr>
                <tr>
                    <td>Designation :</td>
                    <td><input type="text" name="designation"></td>
                </tr>
                <tr>
                    <td>Prix :</td>
                    <td><input type="text" name="prix"></td>
                </tr>
                <tr>
                    <td>Quantite :</td>
                    <td><input type="text" name="quantite"></td>
                </tr>
                <tr>
                    <td>Categorie :</td>
                    <td>
                        <select name="categorie" id="categorie">
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.libelle}">${cat.libelle}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Ajouter">
                        <input type="submit" name="action" value="Modifier">
                        <input type="submit" name="action" value="Rechercher">
                        <input type="submit" name="action" value="+ Quantite">
                        <input type="submit" name="action" value="- Quantite">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div>
        <table>
            <tr>
                <th>Code</th>
                <th>Designation</th>
                <th>Prix</th>
                <th>Quantite</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${produits}" var="pr">
                <tr>
                    <td>${pr.code}</td>
                    <td>${pr.libelle}</td>
                    <td>${pr.prix}</td>
                    <td>${pr.quantite}</td>
                    <td>
                        <form action="Categorie.do" method="post" style="display:inline;">
                            <input type="hidden" name="codeToDelete" value="${pr.code}">
                            <input type="submit" name="action" value="Supprimer">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <nav>
        <a href="Categorie.jsp">Go to Categorie Form</a>
    </nav>
</body>
</html>