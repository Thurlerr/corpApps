<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formPrincipal</title>
</head>
<body>
    <div id="titulo">
        <h1>Solucred</h1>
        <h2>Facilitando o acesso ao crédito des de 2025.</h2>
    </div>
    <div class="bancos">
        <ul>
            <li>Totem - empréstimos a partir de R$1000,00 (juros a.a de 10%)</li>
            <li>Jotun - empréstimos a partir de R$10,00 (juros a.a de 16%)</li>
        </ul>
    </div>
    <form action="empServlet/veloster" method="POST">
        <label for="opcao">Escolha um banco:</label>
        <select name="bancoEscolhido" required>
            <option value="Totem">Totem</option>
            <option value="Totem">Jotun</option>
        </select>

    </form>


    <div class="formulario simular">
        <h3>Simular empréstimo</h3>
        <form action="${pageContext.request.contextPath}/veloster" method="POST">
            <label for="name">Nome Completo</label>
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
    </div>
    <!-- para que a simulação fique na mesma página --> 
    <script>
        document.getElementById(botao de simular).addEventListener('click', () => {
            fetch('formularioSaida.jsp')
            .then(response => {
                if(!response.ok) throw new Error ('deu merda no fetch');
                return response.text();
            })
            .then(data => {
                document.getElementById()
            })
        })
    </script>
</body>
</html>