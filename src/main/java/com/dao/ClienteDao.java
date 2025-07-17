package com.dao;
import java.sql.Statement;
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
        //con.close();
    }

    public int inserir2(Cliente cliente) throws SQLException {
    String sql = "insert into cliente(nome, cpf, renda) values(?, ?, ?)";
    PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    stmt.setString(1, cliente.getNome());
    stmt.setString(2, cliente.getCpf());
    stmt.setDouble(3, cliente.getRenda());
    stmt.executeUpdate(); // ?????????????
    ResultSet rs = stmt.getGeneratedKeys();
    int idGerado = -1;
    if (rs.next()) {
    idGerado = rs.getInt(1);
    }
    rs.close();
    stmt.close();
    //con.close();
    return idGerado;
    }
    
    public void alterar(Cliente cliente) throws SQLException {
    String sql = "UPDATE cliente SET nome = ?, cpf = ?, renda = ? WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, cliente.getNome());
    stmt.setString(2, cliente.getCpf());
    stmt.setDouble(3, cliente.getRenda());
    stmt.setInt(4, cliente.getId());
    stmt.executeUpdate();
    stmt.close();
    //con.close();
}


    public void alterar2(Cliente cliente) throws SQLException {
    String sql = "UPDATE cliente SET nome = ?, cpf = ?, renda = ? WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, cliente.getNome());
    stmt.setString(2, cliente.getCpf());
    stmt.setDouble(3, cliente.getRenda());
    stmt.setInt(4, cliente.getId());
    stmt.executeUpdate();
    stmt.close();
}

    public boolean excluir (String cpf) throws SQLException{
        String sql = "delete from cliente where cpf = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cpf);
        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();
        //con.close();
        return linhasAfetadas > 0;
    }

    public boolean excluir2(String cpf) throws SQLException {
    String sql = "DELETE FROM cliente WHERE cpf = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, cpf);
    int linhasAfetadas = stmt.executeUpdate();
    stmt.close();
    return linhasAfetadas > 0;
}

    public Cliente listarUm (int id) throws SQLException{
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
    //con.close();
    return cliente;
    }

    public Cliente listarUm2(int id) throws SQLException {
    String sql = "SELECT id, nome, cpf, renda FROM cliente WHERE id = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setInt(1, id);
    ResultSet rs = stmt.executeQuery();

    Cliente cliente = null;
    if (rs.next()) {
        cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRenda(rs.getDouble("renda"));
    }
    stmt.close();
    return cliente;
}

    public Cliente buscarPorCpf(String cpf) throws SQLException {
    String sql = "SELECT * FROM cliente WHERE cpf = ?";
    PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        Cliente cliente = null;
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRenda(rs.getDouble("renda"));
        }
    
    return cliente;
}

    public Cliente buscarPorCpf2(String cpf) throws SQLException {
    String sql = "SELECT * FROM cliente WHERE cpf = ?";
    PreparedStatement stmt = con.prepareStatement(sql);
    stmt.setString(1, cpf);
    ResultSet rs = stmt.executeQuery();

    Cliente cliente = null;
    if (rs.next()) {
        cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRenda(rs.getDouble("renda"));
    }
    stmt.close();
    return cliente;
}


    public List<Cliente>listarTodos() throws SQLException {
        String sql = "SELECT id, nome, cpf, renda FROM cliente";
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
        //con.close();
        return listaClientes;
    }

    public List<Cliente> listarTodos2() throws SQLException {
    String sql = "SELECT id, nome, cpf, renda FROM cliente";
    PreparedStatement stmt = con.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    List<Cliente> listaClientes = new ArrayList<>();
    while (rs.next()) {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setCpf(rs.getString("cpf"));
        cliente.setRenda(rs.getDouble("renda"));
        listaClientes.add(cliente);
    }
    stmt.close();
    return listaClientes;
}
}