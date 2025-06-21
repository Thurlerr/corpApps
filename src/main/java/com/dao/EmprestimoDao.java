package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {
        private Connection con;

    public EmprestimoDao(){
        this.con = ConnectionFactory.getConnection();
    } //
        
    public void inserir(EmprestimoDao emprestimo) throws SQLException{
        String sql = "insert into emprestimo(nome, cpf, renda) values(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, emprestimo.getNome());
        stmt.setString(1, emprestimo.getCpf());
        stmt.setDouble(1, emprestimo.getRenda());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public void excluir (int id) throws SQLException{
        String sql = "delete * from cliente where id = ?";
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
