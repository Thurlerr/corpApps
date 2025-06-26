<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Contratar Empréstimo</title>
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

        .container {
            background: white;
            padding: 30px;
            max-width: 800px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
            display: flex;
            gap: 30px;
        }

        .box {
            flex: 1;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        button {
            margin-top: 20px;
            padding: 10px;
            width: 100%;
            background-color: #0073e6;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
        }

        button:hover {
            background-color: #005bb5;
        }

        .resultado {
            margin-top: 20px;
            padding: 10px;
            background-color: #e6f7ff;
            border: 1px solid #0073e6;
            border-radius: 6px;
        }
    </style>
</head>
<body>

<h1 style="text-align: center;">Contratar Empréstimo</h1>

<div class="container">

    <!-- Lado esquerdo: Buscar cliente -->
    <div class="box">
        <form action="${pageContext.request.contextPath}/BuscarClienteServlet" method="POST">
            <label for="cpf">Buscar cliente por CPF</label>
            <input type="text" name="cpf" id="cpf" required>
            <button type="submit">Buscar</button>
        </form>

        <c:if test="${not empty cliente}">
            <label>Nome:</label>
            <p>${cliente.nome}</p>

            <label>CPF:</label>
            <p>${cliente.cpf}</p>

            <label>Renda:</label>
            <p>R$ ${cliente.renda}</p>
        </c:if>
    </div>

    <!-- Lado direito: Contratar empréstimo -->
    <div class="box">
        <form action="${pageContext.request.contextPath}/ContratarEmprestimoServlet" method="POST">
            <c:if test="${not empty cliente}">
                <input type="hidden" name="cpf" value="${cliente.cpf}">

                <label for="banco">Banco</label>
                <select name="banco" id="banco">
                    <option value="Totem">Totem</option>
                    <option value="Jotun">Jotun</option>
                </select>

                <label for="valor">Valor do Empréstimo</label>
                <input type="number" name="valorDesejado" id="valor" step="0.01" required>

                <label for="parcelas">Número de Parcelas</label>
                <input type="number" name="parcelas" id="parcelas" required>

                <button type="submit">Contratar</button>
            </c:if>
        </form>

        <c:if test="${not empty resultado}">
            <div class="resultado">
                ${resultado}
            </div>
        </c:if>
    </div>

</div>

</body>
</html>
