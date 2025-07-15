import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.model.Banco;
import com.model.Cliente;
import com.model.Emprestimo;

public class TestEmprestimoModel {
    
@Test
public void testeCalcularEmprestimoTrue () {
    Cliente clienteTeste = new Cliente();
    clienteTeste.setRenda(5000.00);
    Emprestimo empTeste = new Emprestimo(clienteTeste);
    Banco bancoTeste = new Banco("Thurler", 20.0 );

    boolean result = empTeste.calcularEmprestimo(bancoTeste, 200    , 10);
    assertEquals(true, result);
}

@Test 
public void testeCalcularEmprestimoFalse () {
    Cliente clienteTeste = new Cliente();
    clienteTeste.setRenda(300.00);
    Emprestimo empTeste = new Emprestimo(clienteTeste);
    Banco bancoTeste = new Banco("Thurler", 20.0 );

    boolean result = empTeste.calcularEmprestimo(bancoTeste, 2000    , 10);
    assertEquals(false, result);
}

@Test
public void testeSimularEmprestimo (){
    Cliente clienteTeste = new Cliente();
    clienteTeste.setRenda(5000.00);
    Emprestimo empTeste = new Emprestimo(clienteTeste);
    Banco bancoTeste = new Banco("Thurler", 20.0 );

    String result = empTeste.simularEmprestimo(bancoTeste, 200, 10);
    String expected = "Taxa de juros mensal: 1.6666666666666667 Custo Efetivo Total (CET): 233.33333333333334 parcelas de R$: 23.333333333333336";
    assertEquals(expected, result);
    //FUNCIONANDO, MAS TEM QUE TRUNCAR A DIZIMA OU TROCAR O ASSETEQUALS PRA CONTAINS PRA N
    //FICAR RIDICULO (OLHAR NA DOCUMENTAÇÃO DO JUNIT)
}


}
