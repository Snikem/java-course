package edu.hw2;
import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    @DisplayName("Тест моей математики")
    void TestMath() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult);
        var res = new Expr.Addition(exp, new Expr.Constant(1));
        System.out.println(res + " = " + res.evaluate());
        //exp((2 + 4) * (-1)) + 1 = 1.0024787521766663
        assertThat(res.evaluate()).isEqualByComparingTo(1.0024787521766663);

    }
}
