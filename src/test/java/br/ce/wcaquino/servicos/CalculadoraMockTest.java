package br.ce.wcaquino.servicos;

import org.junit.Test;
import org.mockito.Mockito;

public class CalculadoraMockTest {

    @Test
    public void  teste(){
         Calculadora calc = Mockito.mock((Calculadora.class));
         Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5); //Se ouver mais que um parametro deve ser enviado 2 mathers não aceita *(1, Mockito.anyInt(2)
                                                                         //Passa os valores para somar mas independentemente ira retornar 5 thenReturn(5)

         System.out.println(calc.somar(1,8));
    }
}