<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form id="form-post">
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" required><br><br>

        <label for="cpf">CPF:</label><br>
        <input type="text" id="cpf" name="cpf" required><br><br>

        <label for="renda">Renda:</label><br>
        <input type="number" id="renda" name="renda" required><br><br>

        <button type="submit">Inserir</button>
    </form>

    <form id="form-get">
        <label for="cpf-get">Buscar por CPF:</label><br>
        <input type="text" id="cpf-get" name="cpf-get" required><br><br>

        <button type="submit">Buscar</button>
    </form>
    <a href="${pageContext.request.contextPath}/view/paginaPrincipal.jsp">Voltar</a>

      <script>
        // Submeter o formulário com post
        document.getElementById("form-post").addEventListener("submit", async function(e) {
            e.preventDefault();

            const cliente = {
                nome: document.getElementById("nome").value,
                cpf: document.getElementById("cpf").value,
                renda: parseFloat(document.getElementById("renda").value),
            };

            const response = await fetch(`http://localhost:8080/solucred/api/cliente/inserir`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(cliente)
            });

            if (response.ok) {
                alert("Cliente criado com sucesso no banco de dados.");
                // window.location.href = "/sisvenda/produtolistarjson.html";
            } else {
                alert("Erro ao criar cliente.");
            }
        });



        //usar o formulário pra GET
        document.getElementById("form-get").addEventListener("submit", async function(e) {
            e.preventDefault();

        const cpf = document.getElementById("cpf-get").value;

        const response = await fetch(`http://localhost:8080/solucred/buscarClienteJson?cpf=` + cpf , {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                },
            });

        if (response.ok) {
            const div = document.createElement('div');
            const body = document.querySelector('body');
            const clientes = await response.json();

            div.innerHTML = "<p>Nome: " + clientes.nome + "<br/>CPF: " + clientes.cpf + "<br/>Renda:" + clientes.renda + "<p>";

            body.appendChild(div)

            } else {
                alert("Erro ao buscar cliente.");
            }
        })
    </script>


</body>
</html>
