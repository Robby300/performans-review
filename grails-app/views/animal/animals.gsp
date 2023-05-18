<%--
  Created by IntelliJ IDEA.
  User: isfront
  Date: 18.05.2023
  Time: 13:59
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>animals List</title>
</head>

<body>

    <table>
        <tr>
            <th>Кличка</th>
            <th>Вес</th>
            <th>Возраст</th>
            <th>Здоров</th>
        </tr>
        <g:each var="animal" in="${animals}">
            <tr>
                <td>${animal.name}</td>
                <td>${animal.weight}</td>
                <td>${animal.age}</td>
                <td>${animal.isHealthy}</td>
            </tr>
        </g:each>
    </table>

</body>
</html>
