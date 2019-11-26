import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilityTest {

    @Test
    void findFileOrDirectory() {
        List<Path> result = FileUtility.findFileOrDirectory("/Users/alice/PJATK","Puzzle.jar");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("/Users/alice/PJATK/Puzzle.jar", result.get(0).toString());
    }

    @Test
    void fileWithContent() {
        List<Path> result = FileUtility.fileWithContent("/Users/alice/PJATK", "Cats are cute");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("/Users/alice/PJATK/3_semester/Hey.txt", result.get(0).toString());

    }

    @Test
    void findFileOrDirectoryPar() {
        List<Path> result = FileUtility.findFileOrDirectoryPar("/Users/alice/PJATK","Puzzle.jar");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("/Users/alice/PJATK/Puzzle.jar", result.get(0).toString());
    }

    @Test
    void fileWithContentPar() {
        List<Path> result = FileUtility.fileWithContentPar("/Users/alice/PJATK", "Cats are cute");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("/Users/alice/PJATK/3_semester/Hey.txt", result.get(0).toString());
    }
}