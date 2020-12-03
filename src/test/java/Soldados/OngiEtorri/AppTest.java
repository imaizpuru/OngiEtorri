package Soldados.OngiEtorri;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;

import ServidorLN.DAO;

import org.junit.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest 
    extends TestCase
    
{
	@Rule
    public ContiPerfRule rule = new ContiPerfRule();
	private DAO dao = DAO.getInstance();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	
        super( testName );
    }  
    /**
     * Rigourous Test :-)
     */
    @Test
    @PerfTest(invocations = 10000,threads = 100)
    public void testApp()
    {
    	boolean retorno;
    	
    	retorno = dao.ComprobarUsuario("a", "a");
    	System.out.println(retorno);
    	
        assertTrue(retorno);
    }
}
