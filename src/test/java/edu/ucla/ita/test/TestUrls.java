package edu.ucla.ita.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class TestUrls extends TestCase {
	
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public TestUrls(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestUrls.class);
	}


	
	public void testUrls() {
		// test AuthInfo
				
		String charset = "UTF-8";
		//String url = "https://cis.ucla.edu/ws/IWEMenuCollectorService/MCService.svc?wsdl";
		//String url = "http://www.google.com/";
		String url="https://sonardev.it.ucla.edu";
		
		URLConnection connection;
		try {
			connection = new URL(url ).openConnection();
			connection.setRequestProperty("Accept-Charset", charset);
			InputStream response = connection.getInputStream();
			System.out.println ("Resp:" + response );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue( false   );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue( false   );
		}
	}


}
