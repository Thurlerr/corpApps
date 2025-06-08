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
        <input type="text" name="nome">

        <label for="cpf">CPF</label>
        <input type="text" name="cpf">

        <label for="renda">renda</label>
        <input type="text" name="renda">

        <label for="parcelas">parcelas desejadas</label>
        <input type="number" name="parcelas">

        <label for="valorDesejado">Valor desejado</label>
        <input type="number" name="valorDesejado">

        <button type="submit">Simular</button>
    </form>
</body>
</html>