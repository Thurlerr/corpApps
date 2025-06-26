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

@WebServlet("/BuscarClienteServlet")
public class BuscarClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        ClienteDao dao = new ClienteDao();

        try {
            Cliente clienteEncontrado = null;
            for (Cliente c : dao.listarTodos()) {
                if (c.getCpf().equalsIgnoreCase(cpf)) {
                    clienteEncontrado = c;
                    break;
                }
            }

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
