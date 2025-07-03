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

@WebServlet("/buscarClienteJson")
public class BuscarClienteJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf"); // filtro
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            ClienteDao dao = new ClienteDao();
            Cliente clienteEncontrado = null;

            for (Cliente c : dao.listarTodos()) {
                if (c.getCpf().equalsIgnoreCase(cpf)) {
                    clienteEncontrado = c;
                    break;
                }
            }

            if (clienteEncontrado != null) {
                Gson gson = new Gson();
                String json = gson.toJson(clienteEncontrado);
                out.print(json);
            } else {
                out.print("{\"erro\": \"Cliente não encontrado\"}");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().print("{\"erro\": \"Erro no servidor\"}");
        }
    }
}
