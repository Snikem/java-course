package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double number) implements Expr {
        @Override
        public double evaluate() {
            return number;
        }
    }

    public record Negate(Expr num) implements Expr {
        @Override
        public double evaluate() {
            return -num.evaluate();
        }
    }

    public record Exponent(Expr num) implements Expr {
        @Override
        public double evaluate() {
            return Math.exp(num.evaluate());
        }
    }

    public record Addition(Expr a, Expr b) implements Expr {
        @Override
        public double evaluate() {
            return a.evaluate() + b.evaluate();
        }
    }

    public record Multiplication(Expr a, Expr b) implements Expr {
        @Override
        public double evaluate() {
            return a.evaluate() * b.evaluate();
        }
    }
}
