package com.controller;

import com.dao.ClienteDao;
import com.model.Cliente;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listarClientesJson")
public class ListarClientesJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            ClienteDao dao = new ClienteDao();
            List<Cliente> lista = dao.listarTodos();

            if (lista == null || lista.isEmpty()) {
                out.print("{\"mensagem\": \"Nenhum cliente encontrado.\"}");
            } else {
                Gson gson = new Gson();
                String json = gson.toJson(lista);
                out.print(json);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().print("{\"erro\": \"Erro ao buscar clientes.\"}");
        }
    }
}
