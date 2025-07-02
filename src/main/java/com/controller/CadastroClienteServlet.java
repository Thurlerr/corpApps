package com.controller;

import java.io.IOException;

import com.dao.ClienteDao;
import com.model.Cliente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CadastroClienteServlet")
public class CadastroClienteServlet extends HttpServlet {

    public CadastroClienteServlet () {
        super();
    }
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        String nome = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        double renda = Double.parseDouble(request.getParameter("renda"));

        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente(nome, cpf, renda);
        

        String nomeCliente = "";
        try {
            clienteDao.inserir(cliente);
             nomeCliente = "Cliente " + cliente.getNome() + " cadastrado!";
        } catch (Exception e) {
             nomeCliente = "Erro interno no servidor";
            System.out.println("deu errado: " + e);
        }



        

        request.setAttribute("nomeCliente", nomeCliente);
        RequestDispatcher rd = request.getRequestDispatcher("view/cadastroCliente.jsp");
        rd.forward(request,response);

    };
}

//jsp existe e expoe formulario
//usuario preenche formulario com dados, e dados são enviados para serem tratados no servlet via method post, chamando simularemprestimo
//servlet trata e devolve para jsp, via dispatcher que contém variáveis modificadas guardadas na memoria com request.setAttribute
