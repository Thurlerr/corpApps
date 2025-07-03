<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Lista de Clientes</title>
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
            margin-bottom: 30px;
        }
        .container {
            background-color: white;
            border-radius: 10px;
            padding: 20px 30px;
            max-width: 800px;
            margin: 0 auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #0073e6;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f8faff;
        }
        .mensagem {
            background-color: #e6f7ff;
            border: 1px solid #0073e6;
            color: #005bb5;
            border-radius: 6px;
            padding: 10px;
            max-width: 800px;
            margin: 20px auto;
            text-align: center;
        }
        a.botao-voltar {
            display: inline-block;
            background-color: #0073e6;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: bold;
            margin-bottom: 20px;
        }
        a.botao-voltar:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Lista de Clientes</h1>

        <c:if test="${not empty clientes}">
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Renda</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.nome}</td>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.renda}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty clientes}">
            <div class="mensagem">Nenhum cliente cadastrado.</div>
        </c:if>

        <a href="${pageContext.request.contextPath}/view/cadastroCliente.jsp" class="botao-voltar">Voltar ao Cadastro</a>
    </div>

</body>
</html>
