<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Cliente</title>
    <style>
        body {
            background-image: url('./sean-pollock-PhYq704ffdA-unsplash.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            font-family: Arial, sans-serif;
            margin: 40px;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #0073e6;
        }

        .section {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            margin: 20px auto;
            max-width: 700px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            background-color: #0073e6;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
            margin-top: 20px;
        }

        button:hover {
            background-color: #005bb5;
        }

        .message {
            margin-top: 20px;
            padding: 10px;
            background-color: #e6f7ff;
            border: 1px solid #0073e6;
            border-radius: 6px;
            color: #005bb5;
        }

        .extra-options {
            margin-top: 30px;
        }

        .hidden {
            display: none;
        }
    </style>
    <script>
        function toggleOptions() {
            const options = document.getElementById("extraOptions");
            options.classList.toggle("hidden");
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/CadastroClienteServlet" method="POST">
        <label for="name">Nome</label>
        <input type="text" id="name" name="name">
        <label for="cpf">CPF</label>
        <input type="text" id="cpf" name="cpf">
        <label for="renda">Renda</label>
        <input type="text" id="renda" name="renda">

        <button type="submit">Cadastrar</button>
    </form>

    <c:if test="${not empty nomeCliente}">
        <div class="message">
            Cliente ${nomeCliente} cadastrado com sucesso!
        </div>
    </c:if>

    <div class="extra-options">
        <button onclick="toggleOptions()">Mais opções</button>

        <div id="extraOptions" class="hidden">
            <form action="${pageContext.request.contextPath}/BuscarTodosClientesServlet" method="GET" style="margin-top: 20px;">
                <button type="submit">Listar Todos os Clientes</button>
            </form>

            <form action="${pageContext.request.contextPath}/ExcluirClienteServlet" method="POST" style="margin-top: 20px;">
                <label for="cpfExcluir">CPF do Cliente a Excluir</label>
                <input type="text" id="cpfExcluir" name="cpf">
                <button type="submit">Excluir Cliente</button>
            </form>
        </div>
        <a href="${pageContext.request.contextPath}/view/paginaPrincipal.jsp" class="botao-voltar">Voltar à página principal</a>
    </div>
</body>
</html>
