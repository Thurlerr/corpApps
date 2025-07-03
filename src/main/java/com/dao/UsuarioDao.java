package com.dao;

import com.model.Usuario;
import java.sql.*;

public class UsuarioDao {
    private Connection con;

    public UsuarioDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public Usuario buscarPorLoginSenha(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();
        Usuario usuario = null;

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setCorFundo(rs.getString("cor_fundo"));
            usuario.setCorFonte(rs.getString("cor_fonte"));
        }

        rs.close();
        stmt.close();
        con.close();
        return usuario;
    }

    public void inserir(Usuario usuario) throws SQLException {
    String sql = "INSERT INTO usuario (login, senha, cor_fundo, cor_fonte) VALUES (?, ?, ?, ?)";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, usuario.getLogin());
    stmt.setString(2, usuario.getSenha()); // criptografar com BCrypt
    stmt.setString(3, usuario.getCorFundo());
    stmt.setString(4, usuario.getCorFonte());

    stmt.executeUpdate();
    stmt.close();
    con.close();
}

}
