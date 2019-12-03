import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtility {

    public static List<Path> findFileOrDirectory (String directory, String fileName) {

        BiPredicate<Path, BasicFileAttributes> filePred = (path, attr) -> {
            File fil = path.toFile();
            return fil.getName().contains(fileName);
        };

        List<Path> paths = new ArrayList<>();

        try {
            Stream<Path> stream =
            Files.find(Paths.get(directory), Integer.MAX_VALUE, filePred);
            paths = stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e);
        }
        return paths;
    }

    public static List<Path> findFileOrDirectoryPar (String directory, String fileName) {

        BiPredicate<Path, BasicFileAttributes> filePred= (path, attr) -> {
            File fil = path.toFile();
            return fil.getName().contains(fileName);
        };

        List<Path> paths = new ArrayList<>();

        try {
            Stream<Path> stream =
                    Files.find(Paths.get(directory), Integer.MAX_VALUE, filePred);

            paths = stream.parallel().collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e);
        }
        return paths;
    }

    public static List<Path> fileWithContent(String directory, String content) {

        BiPredicate<Path, BasicFileAttributes> contentPred = (path, attr) -> {
            File fil = path.toFile();
            return !fil.isDirectory()&& fil.canRead() && checkContent(path.toString(), content);
        };

        List<Path> pathsWithContent = new ArrayList<>();

        try {
            Stream<Path> stream =
                    Files.find(Paths.get(directory), Integer.MAX_VALUE, contentPred);

            pathsWithContent = stream.collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e);
        }
        return pathsWithContent;
    }

    public static List<Path> fileWithContentPar(String directory, String content) {
        BiPredicate<Path, BasicFileAttributes> contentPred = (path, attr) -> {
            File fil = path.toFile();
            return !fil.isDirectory()&& fil.canRead() && checkContent(path.toString(), content);
        };

        List<Path> pathsWithContent = new ArrayList<>();

        try {
            Stream<Path> stream =
                    Files.find(Paths.get(directory), Integer.MAX_VALUE, contentPred);

            pathsWithContent = stream.parallel().collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(e);
        }

        return pathsWithContent;
    }

    public static boolean checkContent(String file, String content) {
        StringBuilder sb = new StringBuilder();

        try {
            InputStream fileStream = new FileInputStream(file);
            Scanner scanner = new Scanner(fileStream);
            return scanner.findWithinHorizon(content, 0) != null;
        } catch(IOException e) {
            System.out.println(e);
        }

        String fileAsString = sb.toString();
        return fileAsString.contains(content);

    }

}







