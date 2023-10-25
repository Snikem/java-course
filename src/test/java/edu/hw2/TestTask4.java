package edu.hw2;
import edu.hw2.task1.Expr;
import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask4 {

    @Test
    @DisplayName("Тест функции CallingInfo")
    void TestCallingInfo() {
        Task4 task4 = new Task4();
        CallingInfo callingInfo = task4.callingInfo();
        CallingInfo callingInfoTest = new CallingInfo("edu.hw2.TestTask4","TestCallingInfo");
        assertThat(callingInfo).isEqualTo(callingInfoTest);

    }
}
