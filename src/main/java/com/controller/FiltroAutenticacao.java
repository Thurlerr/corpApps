package com.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*") 
public class FiltroAutenticacao implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        String url = req.getRequestURI();
        Object token = session.getAttribute("token");

        System.out.println("REQUISIÇÃO FILTRADA:");
        System.out.println("URL: " + req.getRequestURI());

        if (token != null) {
            System.out.println("TOKEN: " + token + " (usuário logado)");
        } else {
            System.out.println("TOKEN: null (usuário NÃO logado)");
        }


        
        if (token != null) {
    chain.doFilter(request, response); //jsps que exigem autenticação
} else if (url.contains("LoginServlet") || url.equals("/solucred/view/paginaLogin.jsp")) {
    chain.doFilter(request, response);
} else {
   
    res.sendRedirect("/solucred/view/paginaLogin.jsp"); 
}
}
@Override
public void init(FilterConfig filterConfig) {}

@Override
public void destroy() {}
}