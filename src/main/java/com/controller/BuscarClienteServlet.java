package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.ClienteDao;
import com.model.Cliente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//utiliza o listarTodos pra buscar um só, filtrando pelo CPF, servlet utilizado em: 
//contratarEmprestimo.jsp: para buscar o cliente que irá contratar o emprestimo

@WebServlet("/BuscarClienteServlet")
public class BuscarClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        ClienteDao dao = new ClienteDao();

        try {
            Cliente clienteEncontrado = null;
            clienteEncontrado = dao.buscarPorCpf(cpf); // substituição feita aqui


            if (clienteEncontrado != null) {
                request.setAttribute("cliente", clienteEncontrado);
            } else {
                request.setAttribute("resultado", "Cliente não encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("resultado", "Erro ao buscar cliente.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contratarEmprestimo.jsp");
        dispatcher.forward(request, response);
    }
}
