<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>

 <!DOCTYPE html>
 <html lang="en">
 <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>formularioSaida</title>
 </head>
 <body>
    <c:forEach var="emp" items="${cliente.emprestimos}">
    <p>Banco: ${emp.nomeBanco}</p>
    <p>Valor Desejado: ${emp.valorDesejado}</p>
    <p>Parcelas: ${emp.parcelas}</p>
    <p>CET: ${emp.CET}</p>
    <p>Taxa de Juros Mensal: ${emp.taxaJurosMensal}</p>
    <p>Valor das Parcelas: ${emp.valorParcelas}</p>
    <hr>
</c:forEach>

 </body>
 </html>