package converter;

import org.junit.Assert;
import org.junit.Test;

public class TestConverter {

    @Test
    public void testSpaces() throws StringNotValidException {
        Converter numb = new Converter(" 2 3");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String contains spaces");
        }
    }

    @Test
    public void testLetters() throws StringNotValidException {
        Converter numb = new Converter("ASDASD3");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String contains letters");
        }
    }

    @Test
    public void testDots() throws StringNotValidException {
        Converter numb = new Converter("2.3");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String contains dots");
        }
    }

    @Test
    public void testCommas() throws StringNotValidException {
        Converter numb = new Converter("2,3");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String contains commas");
        }
    }

    @Test
    public void testMax() throws StringNotValidException {
        Converter numb = new Converter("32768");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String number exced the maximum value allowed");
        }
    }

    @Test
    public void testMin() throws StringNotValidException {
        Converter numb = new Converter("-32769");
        try {
            numb.convertString();
            Assert.fail("Expected an exception");
        } catch (StringNotValidException snve) {
            System.out.println("String number exced the minim value allowed");
        }
    }

    @Test
    public void testCorrectness() throws StringNotValidException {
        Converter numb = new Converter("32767");
        Assert.assertEquals(numb.convertString(), 32767);
        System.out.println("Max value accepted");

        numb = new Converter("-32768");
        Assert.assertEquals(numb.convertString(), -32768);
        System.out.println("Min value accepted");

        numb = new Converter(" 3");
        Assert.assertEquals(numb.convertString(), 3);
        System.out.println("Initial space accepted");

        numb = new Converter("+3");
        Assert.assertEquals(numb.convertString(), 3);
        System.out.println("Initial sign accepted");
    }

}
