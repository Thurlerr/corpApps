package com.controller;

import com.dao.UsuarioDao;
import com.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String corFundo = request.getParameter("corFundo");
        String corFonte = request.getParameter("corFonte");

        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setCorFundo(corFundo);
        usuario.setCorFonte(corFonte);

        UsuarioDao dao = new UsuarioDao();

        try {
            dao.inserir(usuario);

            request.setAttribute("sucesso", "Usuário cadastrado com sucesso!");
            request.getRequestDispatcher("view/cadastroUsuario.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao cadastrar usuário.");
            request.getRequestDispatcher("view/cadastroUsuario.jsp").forward(request, response);
        }
    }
}
