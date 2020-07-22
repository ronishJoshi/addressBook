package examples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import examples.AddressBookUtils;
import org.junit.Test;
import  static org.junit.Assert.*;
/**
 *
 * @author SONY
 */
public class TestTest {
    
    public TestTest() {
    }

    /**
     * Test of isNumeric method, of class Test.
     * @param str
     * @return 
     */
    @Test
    public void testIsNumeric() {
        Boolean actualResult = AddressBookUtils.isNumeric("123");
        Boolean expectedResult = true;
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsNumeric1() {
        Boolean actualResult = AddressBookUtils.isNumeric("ABC");
        Boolean expectedResult = false;
        
        assertEquals(expectedResult, actualResult);
    }
     @Test
    public void testIsEmailValid() {
        Boolean actualResult = AddressBookUtils.isEmailValid("example@mail.com");
        Boolean expectedResult = true;
        
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmailValid1() {
        Boolean actualResult = AddressBookUtils.isEmailValid("A@b@c@domain.com");
        Boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
    /**
     * Test of main method, of class Test.
     */
    @Test
    public void testMain() {
    }
    
}
