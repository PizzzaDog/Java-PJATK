import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ZipUtility {

    public static List<ZipEntry> findInZip(String zip, String fileName) {
        List<ZipEntry> entries = new ArrayList<>();
        Predicate<ZipEntry> zipPred = (p) -> p.getName().contains(fileName);
        try {
            ZipFile zipFile = new ZipFile(zip);
            entries = zipFile.stream()
                    .filter(zipPred)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static List<ZipEntry> findInZipPar( String zip, String fileName) {
        List<ZipEntry> entries = new ArrayList<>();
        Predicate<ZipEntry> zipPred = (p) -> p.getName().contains(fileName);
        try {
            ZipFile zipFile = new ZipFile(zip);
            entries = zipFile.stream().parallel()
                    .filter(zipPred)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static List<ZipEntry>  fileWithContent(String zip,String content) {
        List<ZipEntry> entries = new ArrayList<>();
        try {
            ZipFile zipFile = new ZipFile(zip);
            entries = zipFile.stream()
                    .filter(e -> !e.isDirectory() && ZipUtility.checkContent(e, zipFile, content))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static List<ZipEntry> fileWithContentPar(String zip,String content) {
        List<ZipEntry> entries = new ArrayList<>();
        try {
            ZipFile zipFile = new ZipFile(zip);
            entries = zipFile.stream().parallel()
                    .filter(e -> !e.isDirectory() && ZipUtility.checkContent(e, zipFile, content))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static boolean checkContent(ZipEntry entry, ZipFile zipFile, String content) {
        StringBuilder sb = new StringBuilder();
        InputStream in;
        try {
            in = zipFile.getInputStream(entry);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            String line = buf.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
        } catch (IOException e) {
            System.out.print(e);
        }

        String ZipFileAsString = sb.toString();
        return ZipFileAsString.contains(content);

    }
}
