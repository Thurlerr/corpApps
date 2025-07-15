package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.ClienteDao;
import com.model.Banco;
import com.model.Cliente;
import com.model.Emprestimo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//faz a mesma coisa que o  BuscarClienteServlet? exportar comentario que documenta
@WebServlet("/ContratarEmprestimoServlet")
public class ContratarEmprestimoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf = request.getParameter("cpf");
        double valorDesejado = Double.parseDouble(request.getParameter("valorDesejado"));
        int parcelas = Integer.parseInt(request.getParameter("parcelas"));
        String nomeBanco = request.getParameter("banco");

        ClienteDao dao = new ClienteDao();
        Cliente cliente = null;
        Banco banco;

        try {
            for (Cliente c : dao.listarTodos()) {
                if (c.getCpf().equalsIgnoreCase(cpf)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente == null) {
                request.setAttribute("resultado", "Cliente não encontrado.");
            } else {
                // Define os bancos fixos, mover esses caras pra model depois
                if ("Totem".equalsIgnoreCase(nomeBanco)) {
                    banco = new Banco("Totem", 15.0);
                } else {
                    banco = new Banco("Jotun", 20.0);
                }

                Emprestimo emprestimo = new Emprestimo(cliente);
                String retorno = emprestimo.simularEmprestimo(banco, valorDesejado, parcelas);

                if (!retorno.equals("cliente pobre")) {
                    emprestimo.contratarEmprestimo();
                    request.setAttribute("resultado", "Empréstimo contratado com sucesso!\n" + retorno);
                } else {
                    request.setAttribute("resultado", "Não foi possível contratar: renda insuficiente.");
                }

                request.setAttribute("cliente", cliente); // reexibir dados
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("resultado", "Erro ao contratar empréstimo.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contratarEmprestimo.jsp");
        dispatcher.forward(request, response);
    }
}
