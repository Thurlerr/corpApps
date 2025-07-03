<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Simular Empréstimo</title>
    <style>
        body {
            background-image: url('./photo-1639781895346-054825a58d4a.avif');
            background-size: contain;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            margin: 40px;
            color: #333;
        }


        .container {
            background: white;
            padding: 30px;
            max-width: 600px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #0073e6;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        select, input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border-radius: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            background-color: #0073e6;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
            margin-top: 20px;
            width: 100%;
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
            color: #005bb5;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Simular Empréstimo</h1>
    <form action="${pageContext.request.contextPath}/SimulacaoServlet" method="POST">
        <label for="banco">Banco</label>
        <select id="banco" name="banco">
            <option value="Totem">Totem</option>
            <option value="Jotun">Jotun</option>
        </select>

        <label for="valor">Valor do Empréstimo</label>
        <input type="number" id="valor" name="valorDesejado" step="0.01" required>

        <label for="parcelas">Número de Parcelas</label>
        <input type="number" id="parcelas" name="parcelas" min="1" required>

        <button type="submit">Simular</button>
    </form>

    <c:if test="${not empty simulacaoResultado}">
        <div class="resultado">
            ${simulacaoResultado}
        </div>
    </c:if>
</div>

</body>
</html>
