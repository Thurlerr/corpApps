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
    <form action="${pageContext.request.contextPath}/clienteServlet" method="POST">
        <label for="name">Nome</label>
        <input type="text" id="name" name="name">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf" name="cpf">
        <label for="renda">Renda</label>
        <input type="text" id="renda" name="renda">
        <!-- <label for="valorDesejado">Valor Desejado</label>
        <input type="text" id="valorDesejado" name="valorDesejado">
        <label for="parcelas">Parcelas</label>
        <input type="text" id="parcelas" name="parcelas"> -->

        <button type="submit">Cadastrar</button>
    </form>
    <div>
        cliente ${nomeCliente} cadastrado!
    </div>
</body>
</html>