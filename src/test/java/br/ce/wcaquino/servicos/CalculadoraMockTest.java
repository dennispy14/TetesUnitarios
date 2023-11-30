package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CalculadoraMockTest {

    @Mock
    private Calculadora calcMock;

    @Spy
    private Calculadora calcSpy;

//    @Spy //Spy não funciona com interface
//    private EmailService email;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void devoMostrarDiferencaMockSpy(){
        Mockito.when(calcMock.somar(1,2)).thenReturn(8);
        Mockito.when(calcSpy.somar(1,2)).thenReturn(8);

        System.out.println("Mock:" + calcMock.somar(1,5)); // Quando o Mock não encontra o valor esperado no caso seria 8
                                                                 // ele mostra o valor padrão como seria um inteiro o valor seria 0.
                                                // Para que o Mockito mostre o valor real executado outro metodo deve ser chamado "thenCallRealMethod()"

        System.out.println("Spy:" + calcSpy.somar(1,5));   // Já o Spy retorna o valor da soma nesse caso 6.

        // No caso do Mockito ele não sabe o que fazer se o resultado não for o esperado por isso ele mostra o seu valor padrão de inteniro 0
        // Já o SPy faz a execução real do metodo e retorna seu valor.
    }

    @Test
    public void  teste(){
         Calculadora calc = Mockito.mock((Calculadora.class));


//         Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5); //Se ouver mais que um parametro deve ser enviado 2 mathers não aceita *(1, Mockito.anyInt(2)
                                                                         //Passa os valores para somar mas independentemente ira retornar 5 thenReturn(5)
        ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calc.somar(argCapt.capture(), Mockito.anyInt())).thenReturn(5);


        Assert.assertEquals(5, calc.somar(1,8));
        System.out.println(argCapt.getAllValues());
    }
}
