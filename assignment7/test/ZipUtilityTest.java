import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.zip.ZipEntry;

import static org.junit.jupiter.api.Assertions.*;

class ZipUtilityTest {

    @Test
    void findInZip() {
        List<ZipEntry> result = ZipUtility.findInZip("/Users/alice/PJATK/zipTest.zip/","Hey");
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals("zipTest/tmp/Hey.txt", result.get(0).toString());
    }

    @Test
    void fileWithContent() {
        List<ZipEntry> result = ZipUtility.fileWithContent("/Users/alice/PJATK/zipTest.zip/", "Cats are cute");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("zipTest/tmp/Hey.txt", result.get(0).toString());
    }

    @Test
    void findInZipPar() {
        List<ZipEntry> result = ZipUtility.findInZipPar("/Users/alice/PJATK/zipTest.zip/","Hey");
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals("zipTest/tmp/Hey.txt", result.get(0).toString());
    }

    @Test
    void fileWithContentPar() {
        List<ZipEntry> result = ZipUtility.fileWithContentPar("/Users/alice/PJATK/zipTest.zip/", "Cats are cute");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("zipTest/tmp/Hey.txt", result.get(0).toString());
    }
}