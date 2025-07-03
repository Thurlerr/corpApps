package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Emprestimo;

public class EmprestimoDao {
    private Connection con;

    public EmprestimoDao() {
        this.con = ConnectionFactory.getConnection();
    }

    public void inserir(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (idCliente, banco, valorDesejado, parcelas, cet, taxaJurosMensal, valorParcelas) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, emprestimo.getCliente().getId());
        stmt.setString(2, emprestimo.getNomeBanco());
        stmt.setDouble(3, emprestimo.getValorDesejado());
        stmt.setInt(4, emprestimo.getParcelas());
        stmt.setDouble(5, emprestimo.getCET());
        stmt.setDouble(6, emprestimo.getTaxaJurosMensal());
        stmt.setDouble(7, emprestimo.getValorParcelas());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM emprestimo WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();
        con.close();
        return linhasAfetadas > 0;
    }
}
