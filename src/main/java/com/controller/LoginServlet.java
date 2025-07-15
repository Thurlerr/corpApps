package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.UsuarioDao;
import com.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //recebe o login e senha daquela tela la de login
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
                //ve se tem no banco de dados
        UsuarioDao dao = new UsuarioDao();
        try {
            Usuario usuario = dao.buscarPorLoginSenha(login, senha);

            if (usuario != null) {
                HttpSession session = request.getSession(); //esse cara cria ou recupera sessao, se o usuario existir
                session.setAttribute("usuario", usuario); //sala o obj do usuario
                session.setAttribute("token", System.currentTimeMillis()); // simples token numérico

                
                System.out.println("ID da sessão geral: " + session.getId());//debgar esse desgraçado


                // Cookies com preferências
                Cookie fundo = new Cookie("corFundo", usuario.getCorFundo());
                Cookie fonte = new Cookie("corFonte", usuario.getCorFonte());

                fundo.setMaxAge(60 * 60 * 24 * 7); // 1 semana
                fonte.setMaxAge(60 * 60 * 24 * 7);

                response.addCookie(fundo);
                response.addCookie(fonte);

                response.sendRedirect("view/inicioLogin.jsp");
            } else {
                request.setAttribute("erro", "Login ou senha inválidos.");
                request.getRequestDispatcher("view/paginaLogin.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao conectar com banco de dados.");
            request.getRequestDispatcher("view/paginaLogin.jsp").forward(request, response);
        }
    }
}
