package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.ClienteDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirClienteServlet")
public class ExcluirClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        ClienteDao dao = new ClienteDao();

        try {
            boolean sucesso = dao.excluir(cpf);

            if (sucesso) {
                request.setAttribute("mensagem", "Cliente excluído com sucesso.");
            } else {
                request.setAttribute("mensagem", "Cliente não encontrado para exclusão.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao excluir cliente.");
        }

        // Redirecionar para alguma página de confirmação ou lista
        request.getRequestDispatcher("view/cadastroCliente.jsp").forward(request, response);
    }
}
