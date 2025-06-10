package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// Padrão de acesso a dados muito difundido.
//  • Deve-se realizar a conversão do mundo OO (Classes) para 
// o relacional (Tabelas). 
// • Métodos padrões provavelmente serão utilizados (incluir, 
// alterar, excluir, listar uma linha da tabela e listar várias 
// linhas da tabela).
public class ClienteDao {
    private Connection con;

    public ClienteDao(){
        this.con = ConnectionFactory.getConnection();
    }
        
// 1. Try– Tentar fazer, se der erro não para a execução do código;
//  2. Localiza o Driver Importado do Mysql (Build path)
//  3. Caso a linha 2, apresente um problema o programa não será 
// encerrado.
//  4. Apresenta a pilha de erro na tela;
//  5. Retorna uma Conexão para quem chamar o método. Ex1: IP; Ex2: 
// Database; Ex3: Login; Ex4: User.
//  6. Em uma conexão pode ocorrer um erro de SQL;
//  7. Caso não seja possível estabelecer uma conexão com o SGBD, o 
// método irá retornar null
    
}
