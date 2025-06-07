<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/veloster" method="POST">
        <label for="name">Nome</label>
        <input type="text" id="name">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf">
        <label for="">renda</label>
        <input type="text" id="renda">
        <button type="submit">Simular</button>
    </form>
    <form action="${pageContext.request.contextPath}/veloster" method="POST">
        <label for="name">Nome</label>
        <input type="text" id="name">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf">
        <label for="">renda</label>
        <input type="text" id="renda">
        <button type="submit">Simular</button>
    </form>
</body>
</html>