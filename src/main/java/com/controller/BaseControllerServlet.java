package com.controller;

import jakarta.servlet.ServletException;
import java.io.IOException;

import com.model.Cliente;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/veloster")
public class BaseControllerServlet extends HttpServlet {

    public BaseControllerServlet () {
        super();
        System.out.println("servlet instanciado");
    }
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String renda = request.getParameter("renda");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        Cliente cliente = new Cliente(nome, cpf, renda);
        response.getWriter().write("cliente"+ (nome) + "instanciado");


        
        System.out.println(nome + "testeservlet");
    };
}

//jsp existe e expoe formulario
//usuario preenche formulario com dados, e dados são enviados para serem tratados no servlet via method post, chamando simularemprestimo
//servlet trata e devolve para jsp, via dispatcher que contém variáveis modificadas guardadas na memoria com request.setAttribute
