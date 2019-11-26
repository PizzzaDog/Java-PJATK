import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class JarUtility {

    public static List<JarEntry> findInJar(String jar, String fileName) {
        List<JarEntry> entries = new ArrayList<>();
        Predicate<JarEntry> jarPred = (p) -> p.getName().contains(fileName);

        try {
            JarFile jarFile = new JarFile(jar);
            entries = jarFile.stream()
                    .filter(jarPred)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static List<JarEntry> findInJarPar(String jar, String fileName) {
        List<JarEntry> entries = new ArrayList<>();
        Predicate<JarEntry> jarPred = (p) -> p.getName().contains(fileName);
        try {
            JarFile zipFile = new JarFile(jar);
            entries = zipFile.stream().parallel()
                    .filter(jarPred)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }


    public static List<JarEntry> fileWithContent(String zip,String content) {
        List<JarEntry> entries = new ArrayList<>();
        try {
            JarFile zipFile = new JarFile(zip);
            Predicate<JarEntry> jarPred = e -> !e.isDirectory() && ZipUtility.checkContent(e, zipFile, content);
            entries = zipFile.stream()
                    .filter(jarPred)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }


    public static List<JarEntry> fileWithContentPar(String jar,String content) {
        List<JarEntry> entries = new ArrayList<>();
        try {
            JarFile jarFile = new JarFile(jar);
            entries = jarFile.stream().parallel()
                    .filter(e -> !e.isDirectory() && JarUtility.checkContentJar(e, jarFile, content))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return entries;
    }

    public static boolean checkContentJar(JarEntry jarEntry, JarFile jarFile, String content) {
        StringBuilder sb = new StringBuilder();
        BufferedReader buf;
        InputStream in;
        try {
            in = jarFile.getInputStream(jarEntry);
            buf = new BufferedReader(new InputStreamReader(in));
            String line = buf.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
        } catch (IOException e) {
            System.out.print(e);
        }

        String JarFileAsString = sb.toString();
        return JarFileAsString.contains(content);
    }
}
