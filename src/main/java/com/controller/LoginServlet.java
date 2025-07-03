package com.controller;

import com.dao.UsuarioDao;
import com.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDao dao = new UsuarioDao();
        try {
            Usuario usuario = dao.buscarPorLoginSenha(login, senha);

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("token", System.currentTimeMillis()); // simples token numérico

                // Cookies com preferências
                Cookie fundo = new Cookie("corFundo", usuario.getCorFundo());
                Cookie fonte = new Cookie("corFonte", usuario.getCorFonte());

                fundo.setMaxAge(60 * 60 * 24 * 7); // 1 semana
                fonte.setMaxAge(60 * 60 * 24 * 7);

                response.addCookie(fundo);
                response.addCookie(fonte);

                response.sendRedirect("view/inicio.jsp");
            } else {
                request.setAttribute("erro", "Login ou senha inválidos.");
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao conectar com banco de dados.");
            request.getRequestDispatcher("view/login.jsp").forward(request, response);
        }
    }
}
