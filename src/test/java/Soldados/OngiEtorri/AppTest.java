package Soldados.OngiEtorri;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;

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
    @PerfTest(invocations = 100000,threads = 1000)
    public void testApp()
    {
        assertTrue( true );
        
    }
}
