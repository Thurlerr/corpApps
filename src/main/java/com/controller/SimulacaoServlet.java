package com.controller;

import java.io.IOException;

import com.model.Banco;
import com.model.Cliente;
import com.model.Emprestimo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SimulacaoServlet")
public class SimulacaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //  Coleta dos dados do formulário
        String nomeBanco = request.getParameter("banco");
        double valorDesejado = Double.parseDouble(request.getParameter("valorDesejado"));
        int parcelas = Integer.parseInt(request.getParameter("parcelas"));

        //  Criar cliente temporário para simular
        Cliente clienteFake = new Cliente("Simulação", "000.000.000-00", 5000.00); // renda fictícia

        // Criar banco com nome e taxa fictícia (ajustável depois com repositório)
        Banco banco = new Banco(nomeBanco, 20.0); // 20% ao ano

        // Simular empréstimo
        Emprestimo emprestimo = new Emprestimo(clienteFake);
        String resultado = emprestimo.simularEmprestimo(banco, valorDesejado, parcelas);

        // Passar resultado para o JSP
        request.setAttribute("simulacaoResultado", resultado);

        // Encaminhar de volta para a página JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/simular.jsp");
        dispatcher.forward(request, response);
    }
}
