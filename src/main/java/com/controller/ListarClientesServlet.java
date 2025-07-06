package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.ClienteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarClientesServlet")
public class ListarClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ClienteDao dao = new ClienteDao();
            request.setAttribute("clientes", dao.listarTodos());
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao listar clientes.");
        }

        request.getRequestDispatcher("view/listarClientes.jsp").forward(request, response);
    }
}