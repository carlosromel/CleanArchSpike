package br.com.raymond.ca.usecases.factorial;

import br.com.raymond.ca.usecases.exceptions.MandatoryException;
import br.com.raymond.ca.usecases.exceptions.NegativeNumberException;
import br.com.raymond.ca.usecases.exceptions.NotANumberException;

public class CalcFactorial {

    public long getResponse(CalcFactorialRequest request) throws MandatoryException, NotANumberException, NegativeNumberException {
        return getResponse(request.getNumber());
    }

    public long getResponse(long n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException();
        }

        long response = 1;

        for (int i = 1; i <= n; i++) {
            response *= i;
        }

        return response;
    }

}
