import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipUtilityTest {

    @Test
    void findInZip() {
        ZipUtility.findInZip("/Users/alice/PJATK/zipTest.zip/","Alice");

    }

    @Test
    void fileWithContent() {
        ZipUtility.fileWithContent("/Users/alice/PJATK/zipTest.zip/", "Alice is cool");
    }
}