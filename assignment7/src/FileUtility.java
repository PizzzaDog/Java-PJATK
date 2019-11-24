import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtility {

    public static void findFileOrDirectory (String directory, String fileName){
        try {
            Stream<Path> stream =
            Files.find(Paths.get(directory), 5, (path, basicFileAttributes) -> {
                File fil = path.toFile();
                return fil.getName().contains(fileName);
            });

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void fileWithContent(String directory,String content ) {
        try {
            Stream<Path> stream =
                    Files.find(Paths.get(directory), 5, (path, basicFileAttributes) -> {
                        File fil = path.toFile();
                        return !fil.isDirectory() && checkContent(path.toString(), content);
                    });

            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean checkContent(String file, String content){
        StringBuilder sb = new StringBuilder();

        try {
            InputStream fileStream = new FileInputStream(file);
            BufferedReader buf = new BufferedReader(new InputStreamReader(fileStream));
            String line = buf.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }
        } catch(IOException e) {
            System.out.println(e);
        }

        String fileAsString = sb.toString();
        return fileAsString.contains(content);

    }

}







