package edu.hw9;


import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import edu.hw9.task2.DirectorySearchTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectorySearchTest {
    @Test
    @DisplayName("Работоспособность")
    void test1() throws InterruptedException {
        DirectorySearchTask
            directorySearchTask = new DirectorySearchTask(new File("src/test/java/edu/hw9/resourses"), 2);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        var response = forkJoinPool.invoke(directorySearchTask);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(2000, TimeUnit.MILLISECONDS);
        forkJoinPool.close();
        assertThat(response).containsExactlyInAnyOrder(
            new File("src/test/java/edu/hw9/resourses/1/vb"),
            new File("src/test/java/edu/hw9/resourses/2")
        );
    }
}
