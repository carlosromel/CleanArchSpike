package br.com.raymond.ca.usecases;

import br.com.raymond.ca.usecases.exceptions.MandatoryException;
import br.com.raymond.ca.usecases.exceptions.NegativeNumberException;
import br.com.raymond.ca.usecases.exceptions.NotANumberException;
import br.com.raymond.ca.usecases.exceptions.RequestException;
import br.com.raymond.ca.usecases.factorial.CalcFactorial;
import br.com.raymond.ca.usecases.factorial.CalcFactorialRequest;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CalcFactorialTest {

    private CalcFactorial calcFactorial;

    @Before
    public void setUp() {
        calcFactorial = new CalcFactorial();
    }

    @Test
    public void testRegularFlow() throws NegativeNumberException {
        long response = calcFactorial.getResponse(5L);
        assertThat(response, is(120L));
    }

    @Test
    public void testRegularFlowWithRequest() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest("5");
        long response = calcFactorial.getResponse(request);
        assertThat(response, is(120L));
    }

    @Test(expected = NegativeNumberException.class)
    public void testCannotBeNegativeNumber() throws NegativeNumberException {
        calcFactorial.getResponse(-1);
    }

    @Test(expected = NegativeNumberException.class)
    public void testCannotBeNegativeNumberWithRequest() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest("-1");
        calcFactorial.getResponse(request);
    }

    @Test(expected = NotANumberException.class)
    public void testCannotBeText() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest("texto");
        request.getNumber();
    }

    @Test(expected = MandatoryException.class)
    public void testCannotBeNull() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest(null);
        request.getNumber();
    }

    @Test(expected = MandatoryException.class)
    public void testCannotBeEmpty() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest("");
        request.getNumber();
    }

    @Test(expected = MandatoryException.class)
    public void testCannotBeBlank() throws RequestException {
        CalcFactorialRequest request = new CalcFactorialRequest(" ");
        request.getNumber();
    }
}
