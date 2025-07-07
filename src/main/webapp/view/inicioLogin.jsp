<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.model.Usuario" %>
<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String corFundo = "white";
    String corFonte = "black";

    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
    if ("corFundo".equals(c.getName())) corFundo = c.getValue();
    if ("corFonte".equals(c.getName())) corFonte = c.getValue();
}

%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Bem-vindo</title>
    <style>
        body {
            background-color: <%= corFundo %>;
            color: <%= corFonte %>;
            font-family: Arial, sans-serif;
            padding: 40px;
        }

        .box {
            background: #fff;
            color: <%= corFonte %>; 
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

        .buttons {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 30px;
        }

        .buttons button {
            padding: 12px;
            background-color: #0073e6;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        .buttons button:hover {
            background-color: #005bb5;
        }
    </style>
</head>
<body>
<div class="box">
    <h1>Bem-vindo, <%= usuario.getLogin() %>!</h1>

    <div class="buttons">
        <button>Ver Empréstimos Ativos</button>
        <button>Contratar Novo Empréstimo</button>
        <button>Falar com o Gerente</button>
    </div>

    <div class="section">
        <form action="${pageContext.request.contextPath}/view/paginaPrincipal.jsp">
            <button type="submit">Pagina inicial</button>
        </form>
    </div>
</div>
</body>
</html>
