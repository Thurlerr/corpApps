package com.controller;

import com.google.gson.Gson;
import com.model.Cliente;
import com.dao.ClienteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/api/cliente/inserir")
public class ClienteJsonInserirServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lê o JSON do corpo da requisição
        BufferedReader reader = request.getReader();
        StringBuilder jsonBuilder = new StringBuilder();
        String linha;

        while ((linha = reader.readLine()) != null) {
            jsonBuilder.append(linha);
        }

        String json = jsonBuilder.toString();

        // Converte JSON para objeto Cliente
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(json, Cliente.class);

        // Insere no banco de dados
        try {
            ClienteDao dao = new ClienteDao();
            dao.inserir(cliente);

            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json");
            response.getWriter().write("{\"mensagem\": \"Cliente inserido com sucesso!\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"erro\": \"Falha ao inserir cliente.\"}");
            e.printStackTrace();
        }
    }
}
