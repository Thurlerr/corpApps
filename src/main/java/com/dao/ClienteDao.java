package com.dao;
import com.model.Cliente;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// • Métodos padrões provavelmente serão utilizados (incluir, 
// alterar, excluir, listar uma linha da tabela e listar várias 
// linhas da tabela).
public class ClienteDao {
    private Connection con;

    public ClienteDao(){
        this.con = ConnectionFactory.getConnection();
    } //pq é necessário que cliente dao pegue conexao com o banco?
        
    public void inserir(Cliente cliente) throws SQLException{ //verificar como a lista de emprestimo vai ser inserida no sql
        String sql = "insert into cliente(nome, cpf, renda) values(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(1, cliente.getCpf());
        stmt.setDouble(1, cliente.getRenda());
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

        }
    }
}
