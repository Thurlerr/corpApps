import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.ClienteDao;
import com.model.Cliente;


public class TestClienteDao {

    
    Cliente cliente;
    Cliente cliente2;
    Cliente cliente3;
    ClienteDao clienteDao; 
    
    @BeforeEach
    public void inicializar() {
        cliente = new Cliente();
        cliente.setNome("Pedrinho");
    }

@Test
public void inserirBuscar() throws SQLException {
// Inserir
clienteDao = new ClienteDao();
int id = clienteDao.inserir2(cliente);
cliente.setId(id);
assertTrue(cliente.getId() > 0);
// Buscar
clienteDao = new ClienteDao();
cliente2 = clienteDao.listarUm(cliente.getId());
// assertEquals(cliente, cliente2); ao invés de comparar o objeto inteiro, tentar os atributos?
assertEquals(cliente.getNome(), cliente2.getNome());
assertEquals(cliente.getCpf(), cliente2.getCpf());
assertEquals(cliente.getRenda(), cliente2.getRenda(), 0.01); //esse cara aqui dá merda se tirar a precisão opcional, contornar

// Alterar
clienteDao = new ClienteDao();
cliente2.setNome("Pedrao");
clienteDao.alterar(cliente2);
// Buscar cliente alterado
clienteDao = new ClienteDao();
cliente3 = clienteDao.listarUm(cliente2.getId());
assertEquals(cliente2.getNome(), cliente3.getNome());

}
}
