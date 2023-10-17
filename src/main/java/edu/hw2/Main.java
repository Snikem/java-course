package edu.hw2;

import edu.hw2.Expr.Constant;
import edu.hw2.Expr.Exponent;
import edu.hw2.Expr.Multiplication;
import edu.hw2.Expr.Negate;
import edu.hw2.Expr.Addition;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult);
        var res = new Addition(exp, new Constant(1));
        System.out.println(res + " = " + res.evaluate());
        }
}
