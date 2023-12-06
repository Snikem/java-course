package edu.hw9;

import edu.hw9.task2.FilesSearchTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesSearchTest {
    @Test
    @DisplayName("По расширению")
    void test1() throws InterruptedException {
        Predicate<File> predicate = (file) -> (Pattern.compile(".*\\.txt").matcher(file.getName()).find());
        FilesSearchTask
            directorySearchTask = new FilesSearchTask(new File("src/test/java/edu/hw9/resourses"), predicate);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        var response = forkJoinPool.invoke(directorySearchTask);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(2000, TimeUnit.MILLISECONDS);
        forkJoinPool.close();
        assertThat(response).containsExactlyInAnyOrder(
            new File("src/test/java/edu/hw9/resourses/1/ererer.txt"),
            new File("src/test/java/edu/hw9/resourses/1/vb/dfs.txt"),
            new File("src/test/java/edu/hw9/resourses/2/jjj.txt")
        );
    }

    @Test
    @DisplayName("По размеру файла")
    void test2() throws InterruptedException {
        Predicate<File> predicate = (file) -> (file.length() > 10);
        FilesSearchTask
            directorySearchTask = new FilesSearchTask(new File("src/test/java/edu/hw9/resourses"), predicate);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        var response = forkJoinPool.invoke(directorySearchTask);
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(2000, TimeUnit.MILLISECONDS);
        forkJoinPool.close();
        assertThat(response).containsExactlyInAnyOrder(
            new File("src/test/java/edu/hw9/resourses/1/vb/jjjj;"),
            new File("src/test/java/edu/hw9/resourses/2/jk")
        );
    }
}
