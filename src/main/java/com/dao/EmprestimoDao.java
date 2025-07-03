 /*package com.dao;

import com.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Emprestimo;

public class EmprestimoDao {
        private Connection con;

    public EmprestimoDao(){
        this.con = ConnectionFactory.getConnection();
    } //
        
     public void inserir(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (idCliente, idBanco, banco, valorDesejado, parcelas, cet, taxaJurosMensal, valorParcelas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setLong(1, emprestimo.getIdCliente());
        stmt.setLong(2, emprestimo.getIdBanco());
        stmt.setString(3, emprestimo.getBanco());
        stmt.setDouble(4, emprestimo.getValorDesejado());
        stmt.setInt(5, emprestimo.getParcelas());
        stmt.setDouble(6, emprestimo.getCet());
        stmt.setDouble(7, emprestimo.getTaxaJurosMensal());
        stmt.setDouble(8, emprestimo.getValorParcelas());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public void excluir (int id) throws SQLException{
        String sql = "delete from cliente where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeQuery();
        stmt.close();
        con.close();
    }

    public Cliente listar (int id) throws SQLException{
        String sql = "SELECT id, nome, cpf, renda FROM cliente WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Cliente cliente = null; //inicializa cliente 
        if(rs.next()){//next move o cursor pra proxima linha da resposta da query, se ele der true, executa as atribuições ao cliente instanciado acima
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRenda(rs.getDouble("renda"));
        }
    stmt.close();
    con.close();
    return cliente;
    }

    public List<Cliente>listarTodos() throws SQLException {
        String sql = "select id , nome FROM cliente";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        Cliente cliente = null;

        List<Cliente>listaClientes = new ArrayList<Cliente>();
        while(rs.next()){
        cliente = new Cliente ();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRenda(rs.getDouble("renda"));
        listaClientes.add(cliente);
        }
        stmt.close();
        con.close();
        return listaClientes;
    
    }
}
*/