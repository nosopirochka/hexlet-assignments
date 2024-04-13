package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String path1, String path2, String path3) {
        CompletableFuture<String> forFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                var pathOne = Paths.get(path1).toAbsolutePath().normalize();
                return Files.readString(pathOne);
            } catch (IOException err) {
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        CompletableFuture<String> forFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                var pathTwo = Paths.get(path2).toAbsolutePath().normalize();
                return Files.readString(pathTwo);
            } catch (IOException err) {
                System.out.println("NoSuchFileException");
                return null;
            }
        });

        return forFile1.thenCombine(forFile2, (data1, data2) -> {
            try {
                var pathThree = Paths.get(path3).toAbsolutePath().normalize();
                Files.writeString(pathThree, data1, StandardOpenOption.CREATE);
                Files.writeString(pathThree, data2, StandardOpenOption.APPEND);
                return Files.readString(pathThree);
            } catch (IOException error) {
                System.out.println("NoSuchFileException");
                return null;
            }
        }).exceptionally(error -> {
            System.out.println("NoSuchFileException");
            return null;
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/newFile.txt");
        System.out.println(result.get());
        // END
    }
}

