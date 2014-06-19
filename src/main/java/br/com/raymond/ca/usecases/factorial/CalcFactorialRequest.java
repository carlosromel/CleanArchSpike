package br.com.raymond.ca.usecases.factorial;

import br.com.raymond.ca.usecases.exceptions.MandatoryException;
import br.com.raymond.ca.usecases.exceptions.NotANumberException;

public class CalcFactorialRequest {

    private String number;

    public CalcFactorialRequest(String number) {
        this.number = number;
    }

    public long getNumber() throws MandatoryException, NotANumberException {
        if (number == null || number.trim().isEmpty()) {
            throw new MandatoryException();
        }

        try {
            return Long.parseLong(number);
        } catch (NumberFormatException ex) {
            throw new NotANumberException();
        }
    }

}
