package br.com.raymond.ca.deliveries;

import br.com.raymond.ca.usecases.exceptions.MandatoryException;
import br.com.raymond.ca.usecases.exceptions.NegativeNumberException;
import br.com.raymond.ca.usecases.exceptions.NotANumberException;
import br.com.raymond.ca.usecases.factorial.CalcFactorial;
import br.com.raymond.ca.usecases.factorial.CalcFactorialRequest;
import java.util.Scanner;

public class CalcFactorialConsole {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            String number = console.nextLine();

            CalcFactorialRequest request = new CalcFactorialRequest(number);
            CalcFactorial calcFactorial = new CalcFactorial();
            long response = calcFactorial.getResponse(request);

            System.out.printf("%s! = %d\n", number, response);
        } catch (MandatoryException ex) {
            System.out.println("The number is mandatory.");
        } catch (NotANumberException ex) {
            System.out.println("You must specify a number.");
        } catch (NegativeNumberException ex) {
            System.out.println("The number must be non-negative.");
        }
    }

}
