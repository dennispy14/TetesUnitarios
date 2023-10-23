package br.ce.wcaquino.servicos;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;


public class AssertTest {

    @Test
    public void test() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals(2, 2);// int, short e boolean
        Assert.assertEquals(0.51234, 0.512, 0.001);//Informa a margem de erro (ponto flutuante). Resultado True
        Assert.assertEquals(Math.PI, 3.14, 0.01); //Resultado True

        int i = 5;
        Integer i2 = 5;
        Assert.assertEquals(Integer.valueOf(i), i2);
        Assert.assertEquals(i, i2.intValue());

        Assert.assertEquals("bola", "bola");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));


        Usuario u1 = new Usuario("Dennis");
        Usuario u2 = new Usuario("Dennis");
        Usuario u3 = null;

        Assert.assertNotSame(u1, u2); //Incluir metodo equals na classe
        Assert.assertNull(u3);



    }
}
