<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f4f4f4;
        }

        .form-box {
            background: white;
            padding: 30px;
            max-width: 500px;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #0073e6;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }

        button {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #0073e6;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #005bb5;
        }

        .mensagem {
            text-align: center;
            margin-top: 15px;
            color: red;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h2>Cadastro de Usuário</h2>
    <form action="${pageContext.request.contextPath}/CadastroUsuarioServlet" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" required>

        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>

        <label for="corFundo">Cor de fundo preferida</label>
        <select id="corFundo" name="corFundo">
            <option value="white">Branco</option>
            <option value="black">Preto</option>
            <option value="lightblue">Azul Claro</option>
            <option value="beige">Bege</option>
        </select>

        <label for="corFonte">Cor da fonte preferida</label>
        <select id="corFonte" name="corFonte">
            <option value="black">Preto</option>
            <option value="white">Branco</option>
            <option value="darkblue">Azul Escuro</option>
            <option value="maroon">Vinho</option>
        </select>

        <button type="submit">Cadastrar</button>
    </form>

    
<form action="${pageContext.request.contextPath}/view/paginaLogin.jsp" style="margin-top: 10px;">
    <button type="submit">Ir para Login</button>
</form>


<form action="${pageContext.request.contextPath}/view/paginaPrincipal.jsp" style="margin-top: 10px;">
    <button type="submit">Voltar para Página Inicial</button>
</form>


    <c:if test="${not empty erro}">
        <div class="mensagem">${erro}</div>
    </c:if>
    <c:if test="${not empty sucesso}">
        <div class="mensagem" style="color: green;">${sucesso}</div>
    </c:if>
</div>

</body>
</html>
