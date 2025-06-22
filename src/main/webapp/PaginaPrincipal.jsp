<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Bem-vindo ao SoluCred</title>
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

        .section h2 {
            color: #005bb5;
        }

        .section p {
            font-size: 1rem;
            line-height: 1.6;
        }

        .section form {
            margin-top: 10px;
        }

        .section button {
            background-color: #0073e6;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1rem;
        }

        .section button:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>

    <h1>Bem-vindo ao SoluCred</h1>

    <div class="section">
        <h2>Cadastrar Cliente</h2>
        <p>Nesta seção, você poderá cadastrar um novo cliente. O cadastro é necessário para que ele possa contratar um empréstimo futuramente.</p>
        <form action="${pageContext.request.contextPath}/CadastroCliente.jsp">
            <button type="submit">Ir para Cadastro</button>
        </form>
    </div>

    <div class="section">
        <h2>Simular Empréstimo</h2>
        <p>Simule um empréstimo rapidamente, sem cadastro. Você verá os valores de parcelas, taxas e o crédito disponível de forma prática.</p>
        <form action="${pageContext.request.contextPath}/formSimulacao.jsp">
            <button type="submit">Simular Empréstimo</button>
        </form>
    </div>

    <div class="section">
        <h2>Contratar Empréstimo</h2>
        <p>Clientes cadastrados podem prosseguir com a contratação oficial do empréstimo, a partir de uma simulação previamente realizada.</p>
        <form action="${pageContext.request.contextPath}/formContratacao.jsp">
            <button type="submit">Contratar Empréstimo</button>
        </form>
    </div>

</body>
</html>
