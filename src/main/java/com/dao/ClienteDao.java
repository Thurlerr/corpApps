package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Cliente;


public class ClienteDao {
    private Connection con;

    public ClienteDao(){
        this.con = ConnectionFactory.getConnection();
    }
        
    public void inserir(Cliente cliente) throws SQLException{ //verificar como a lista de emprestimo vai ser inserida no sql
        String sql = "insert into cliente(nome, cpf, renda) values(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setDouble(3, cliente.getRenda());
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
        String sql = "select id , nome, cpf, renda FROM cliente";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        Cliente cliente = null;

        List<Cliente>listaClientes = new ArrayList<>();
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