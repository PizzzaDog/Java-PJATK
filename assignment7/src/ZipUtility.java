import java.io.IOException;
import java.nio.file.Paths;
import java.util.zip.ZipFile;


public class ZipUtility {

    public static void findInZip( String zip, String fileName) {

        try {
            ZipFile zipFile = new ZipFile(zip);
            zipFile.stream()
                    .filter(e -> e.getName().contains(fileName))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void fileWithContent(String zip,String content ) {
        try {
            ZipFile zipFile = new ZipFile(zip);
            zipFile.stream()
                    .filter(e -> !e.isDirectory() && FileUtility.checkContent(Paths.get(e.getName()).toString(), content))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void checkContent(String path, String content) {

    }
}
