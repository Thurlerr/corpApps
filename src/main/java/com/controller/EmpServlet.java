package com.controller;

import java.io.IOException;

import com.model.Banco;
import com.model.Cliente;
import com.model.Emprestimo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//separar servlets
//um servlet com dopost que lida com a parte de emprestimo
@WebServlet("/veloster")
public class EmpServlet extends HttpServlet {

    public EmpServlet () {
        super();
        System.out.println("servlet instanciado");
    }
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        double renda = Double.parseDouble(request.getParameter("renda"));
        double valorDesejado = Double.parseDouble(request.getParameter("valorDesejado"));
        int parcelas = Integer.parseInt(request.getParameter("parcelas"));

        // response.setContentType("text/plain");
        // response.setCharacterEncoding("UTF-8");

        Banco tenso = new Banco("tenso", 50.0);
        Cliente cliente = new Cliente(nome, cpf, renda);
        // PrintWriter out = response.getWriter();
        // out.println("cliente "+ cliente.getNome() + " OIIIIIIIII");

        Emprestimo emprestimo1 = new Emprestimo(cliente);
        emprestimo1.simularEmprestimo(tenso, valorDesejado, parcelas);
        emprestimo1.contratarEmprestimo();

        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/formularioSaida.jsp").forward(request,response);

    };
}

//jsp existe e expoe formulario
//usuario preenche formulario com dados, e dados são enviados para serem tratados no servlet via method post, chamando simularemprestimo
//servlet trata e devolve para jsp, via dispatcher que contém variáveis modificadas guardadas na memoria com request.setAttribute
