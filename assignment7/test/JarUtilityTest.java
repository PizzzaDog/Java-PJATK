import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import static org.junit.jupiter.api.Assertions.*;

class JarUtilityTest {

    @Test
    void findInJar() {
        List<JarEntry> result = JarUtility.findInJar("/Users/alice/PJATK/Puzzle.jar", "GameController");
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("sample/GameController.class", result.get(0).toString());
    }

    @Test
    void findInJarPar() {
        List<JarEntry> result = JarUtility.findInJarPar("/Users/alice/PJATK/Puzzle.jar", "GameController");
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("sample/GameController.class", result.get(0).toString());
    }

    @Test
    void fileWithContent() {
        List<JarEntry> result = JarUtility.fileWithContent("/Users/alice/PJATK/Puzzle.jar", "00:07");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("sample/time.txt", result.get(0).toString());
    }

    @Test
    void fileWithContentPar() {
        List<JarEntry> result = JarUtility.fileWithContentPar("/Users/alice/PJATK/Puzzle.jar", "00:07");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("sample/time.txt", result.get(0).toString());
    }
}