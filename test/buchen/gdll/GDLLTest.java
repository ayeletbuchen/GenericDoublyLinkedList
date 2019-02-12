/*
 * JUnit test for GDLL
 */
package buchen.gdll;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ayeletbuchen
 * @version 1
 * @since 11 November 2018
 */
public class GDLLTest<T extends Comparable<? super T>> {

    public GDLLTest()
    {
    }

    /**
     * Test of size method, of class GDLL.
     */
    @Test
    public void testSize()
    {
        System.out.println("size");
        GDLL instance = new GDLL();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        instance.insert(4);
        instance.insert(3);
        instance.insert(2);
        expResult = 3;
        result = instance.size();
        assertEquals(expResult, result);
        instance.removeVal(4);
        expResult = 2;
        result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class GDLL.
     */
    @Test
    public void testInsert_GenericType()
    {
        System.out.println("insert value");
        GDLL instance = new GDLL();
        instance.insert(5);
        instance.insert(6);
        instance.insert(12);
        String expResult = "5 6 12 ";
        String result = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            result += instance.get(ix) + " ";
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class GDLL.
     */
    @Test
    public void testInsert_int_GenericType()
    {
        System.out.println("insert by ordinal");
        GDLL instance = new GDLL();
        boolean result = instance.insert(0, 1);
        boolean expResult = true;
        assertEquals(expResult, result);
        String strExpResult = "1";
        String strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += String.valueOf(instance.get(ix));
        }
        assertEquals(strExpResult, strResult);

        result = instance.insert(-1, 5);
        expResult = false;
        assertEquals(expResult, result);
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += String.valueOf(instance.get(ix));
        }
        assertEquals(strExpResult, strResult);

        result = instance.insert(7, 2);
        expResult = false;
        assertEquals(expResult, result);
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += String.valueOf(instance.get(ix));
        }
        assertEquals(strExpResult, strResult);
        
        result = instance.insert(1, 3);
        expResult = true;
        assertEquals(expResult, result);
        strExpResult = "1 3 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += String.valueOf(instance.get(ix)) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        result = instance.insert(0, 2);
        expResult = true;
        assertEquals(expResult, result);
        strExpResult = "2 1 3 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += String.valueOf(instance.get(ix)) + " ";
        }
        assertEquals(strExpResult, strResult);
    }

    /**
     * Test of removeVal method, of class GDLL.
     */
    @Test
    public void testRemoveVal()
    {
        System.out.println("removeVal");
        GDLL instance = new GDLL();
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        instance.insert(5);
        instance.insert(6);
        instance.insert(7);
        boolean expResult = false;
        boolean result = instance.removeVal(8);
        assertEquals(expResult, result);
        String strExpResult = "0 1 2 3 4 5 6 7 ";
        String strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = true;
        result = instance.removeVal(3);
        assertEquals(expResult, result);
        strExpResult = "0 1 2 4 5 6 7 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = true;
        result = instance.removeVal(0);
        assertEquals(expResult, result);
        strExpResult = "1 2 4 5 6 7 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = true;
        result = instance.removeVal(7);
        assertEquals(expResult, result);
        strExpResult = "1 2 4 5 6 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
    }

    /**
     * Test of removeOrd method, of class GDLL.
     */
    @Test
    public void testRemoveOrd()
    {
        System.out.println("removeOrd");
        GDLL instance = new GDLL();
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        instance.insert(5);
        instance.insert(6);
        instance.insert(7);
        
        Comparable expResult = null;
        Comparable result = instance.removeOrd(8);
        assertEquals(expResult, result);
        String strExpResult = "0 1 2 3 4 5 6 7 ";
        String strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = 3;
        result = instance.removeOrd(3);
        assertEquals(expResult, result);
        strExpResult = "0 1 2 4 5 6 7 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = 0;
        result = instance.removeOrd(0);
        assertEquals(expResult, result);
        strExpResult = "1 2 4 5 6 7 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = 7;
        result = instance.removeOrd(5);
        assertEquals(expResult, result);
        strExpResult = "1 2 4 5 6 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
    }

    /**
     * Test of get method, of class GDLL.
     */
    @Test
    public void testGet()
    {
        System.out.println("get");
        int ord = 0;
        GDLL instance = new GDLL();
        Comparable expResult = null;
        Comparable result = instance.get(ord);
        assertEquals(expResult, result);
        
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        
        expResult = 0;
        result = instance.get(0);
        assertEquals(expResult, result);
        
        expResult = 2;
        result = instance.get(2);
        assertEquals(expResult, result);
        
        expResult = 4;
        result = instance.get(4);
        assertEquals(expResult, result);
    }

    /**
     * Test of set method, of class GDLL.
     */
    @Test
    public void testSet()
    {
        System.out.println("set");
        GDLL instance = new GDLL();
        boolean expResult = false;
        boolean result = instance.set(0, null);
        assertEquals(expResult, result);
        String strExpResult = "";
        String strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        result = instance.set(7, 1);
        assertEquals(expResult, result);
        strExpResult = "";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        
        expResult = true;
        result = instance.set(2, 7);
        assertEquals(expResult, result);
        strExpResult = "0 1 7 3 4 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = true;
        result = instance.set(0, 5);
        assertEquals(expResult, result);
        strExpResult = "5 1 7 3 4 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
        
        expResult = true;
        result = instance.set(4, 3);
        assertEquals(expResult, result);
        strExpResult = "5 1 7 3 3 ";
        strResult = "";
        for (int ix = 0; ix < instance.size(); ++ix)
        {
            strResult += instance.get(ix) + " ";
        }
        assertEquals(strExpResult, strResult);
    }

    /**
     * Test of contains method, of class GDLL.
     */
    @Test
    public void testContains()
    {
        System.out.println("contains");
        GDLL instance = new GDLL();
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        instance.insert(5);
        instance.insert(6);
        instance.insert(7);
        
        boolean expResult = false;
        boolean result = instance.contains(8);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.contains(3);
        assertEquals(expResult, result);
        
        result = instance.contains(0);
        assertEquals(expResult, result);
        
        result = instance.contains(7);
        assertEquals(expResult, result);
        
        instance.removeVal(7);
        expResult = false;
        result = instance.contains(7);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class GDLL.
     */
    @Test
    public void testIsEmpty()
    {
        System.out.println("isEmpty");
        GDLL instance = new GDLL();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        
        instance.insert(1);
        expResult = false;
        result = instance.isEmpty();
        assertEquals(expResult, result);
        
        instance.removeVal(1);
        expResult = true;
        result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class GDLL.
     */
    @Test
    public void testIterator()
    {
        System.out.println("iterator");
        GDLL instance = new GDLL();
        GDLLIterator iterator = instance.iterator();
        Comparable expResult = null;
        Comparable result = iterator.next();
        assertEquals(expResult, result);
        result = iterator.previous();
        assertEquals(expResult, result);
        
        boolean bExpResult = false;
        boolean bResult = iterator.hasNext();
        assertEquals(bExpResult, bResult);
        bResult = iterator.hasPrevious();
        assertEquals(bExpResult, bResult);
        
        instance.insert(0);
        instance.insert(1);
        instance.insert(2);
        
        iterator.reset();
        bResult = iterator.hasPrevious();
        assertEquals(bExpResult, bResult);
        
        bExpResult = true;
        bResult = iterator.hasNext();
        assertEquals(bExpResult, bResult);
                
        expResult = 0;
        result = iterator.next();
        assertEquals(expResult, result);
        
        bResult = iterator.hasNext();
        assertEquals(bExpResult, bResult);
        bResult = iterator.hasPrevious();
        assertEquals(bExpResult, bResult);
        
        expResult = 1;
        result = iterator.next();
        assertEquals(expResult, result);
        
        bResult = iterator.hasPrevious();
        assertEquals(bExpResult, bResult);
        bExpResult = false;
        bResult = iterator.hasNext();
        assertEquals(bExpResult, bResult); 
        
        expResult = 2;
        result = iterator.next();
        assertEquals(expResult, result);
        
        result = iterator.previous();
        assertEquals(expResult, result);
        
        expResult = 1;
        result = iterator.previous();
        assertEquals(expResult, result);
        
        expResult = 0;
        result = iterator.previous();
        assertEquals(expResult, result);
        
        iterator.reset();
        instance.insert(3);
        instance.insert(4);
        instance.removeVal(0);
        
        expResult = 1;
        result = iterator.previous();
        assertEquals(expResult, result);
        
        result = iterator.next();
        assertEquals(expResult, result);
        
        expResult = 2;
        result = iterator.next();
        assertEquals(expResult, result);
        
        instance.removeVal(3);
        
        result = iterator.next();
        assertEquals(expResult, result);
        
        expResult = 4;
        result = iterator.next();
        assertEquals(expResult, result);
        
        instance.removeVal(4);
        
        expResult = 2;
        result = iterator.next();
        assertEquals(expResult, result);
        
        result = iterator.previous();
        assertEquals(expResult, result);
        
        expResult = 1;
        result = iterator.previous();
        assertEquals(expResult, result);
        
        result = iterator.previous();
        assertEquals(expResult, result);
    }
}
