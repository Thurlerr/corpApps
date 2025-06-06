package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//no momento, testar pra ver se consigo fazer as classes interagirem entre si
//o form deverá criar um cliente e permitir simular o empréstimo
//o empréstimo simulado precisa ter o syso impresso na pagina web
@WebServlet("/veloster")
public class BaseControllerServlet extends HttpServlet {

    public BaseControllerServlet () {
        super();
        System.out.println("servlet instanciado");
    }
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        double renda = Double.parseDouble(request.getParameter("renda"));
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        Cliente cliente = new Cliente(nome, cpf, renda);
        PrintWriter out = response.getWriter();
        out.println("cliente "+ cliente.getNome() + " instanciado");


    };
}

//jsp existe e expoe formulario
//usuario preenche formulario com dados, e dados são enviados para serem tratados no servlet via method post, chamando simularemprestimo
//servlet trata e devolve para jsp, via dispatcher que contém variáveis modificadas guardadas na memoria com request.setAttribute
