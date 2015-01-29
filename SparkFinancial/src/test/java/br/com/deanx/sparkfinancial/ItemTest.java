/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.deanx.sparkfinancial;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 *
 * @author alex
 */
public class ItemTest {

    private Item basicImported;
    private Item basicNational;
    private Item supImported;
    private Item supNational;
    
    @Before
    public void init() {
//        MockitoAnnotations.initMocks(this);
        supImported = new Item("Teste", new BigDecimal(12.00), 12, true, "cd");
        supNational = new Item("Teste", new BigDecimal(14.99), 12, false, "cd");
        basicImported = new Item("Teste", new BigDecimal(12.00), 12, true, "book");
        basicNational = new Item("Teste", new BigDecimal(12.49), 12, false, "book");
    }

    /**
     * Test of calculatePrice method, of class Item.
     */
    @Test
    public void testCalculatePrice() {
       // when(item.isTaxed()).thenReturn(true);
        // System.out.println(item.isTaxed());
    }

    @Test
    public void shoudNotBeTaxed() {
        assertTrue(basicNational.isNotTaxed());
        assertTrue(basicImported.isNotTaxed());
    }

    @Test
    public void shouldBeTaxed() {
        assertFalse(supImported.isNotTaxed());
        assertFalse(supNational.isNotTaxed());
    }
    
    @Test
    public void shouldCalculateRightPriceForBasicNational(){
       basicNational.calculatePrice();
        assertEquals(new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP),basicNational.getPrice());
    }
}
