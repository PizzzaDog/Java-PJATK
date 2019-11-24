import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilityTest {

    @Test
    void findFileOrDirectory() {
        FileUtility.findFileOrDirectory("/Users/alice/PJATK","Puzzle.jar");
    }

    @Test
    void fileWithContent() {
        FileUtility.fileWithContent("/Users/alice/PJATK", "Alice is cool");
    }
}