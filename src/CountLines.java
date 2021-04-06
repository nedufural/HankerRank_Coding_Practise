import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CountLines {
private static BufferedReader result;
    public static long count(String text) {

       // System.out.println(Files.lines(path).count()); ;

        BufferedReader size = null;
        long lines = 0;
        List<String> filePath = getJavaFilesPaths("C:\\Users\\admin\\Pictures\\Camera Roll\\");
        System.out.println(filePath.get(0));
        System.out.println(filePath.get(1));
        try {
            String line = result.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = result.readLine();
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for (String s : filePath) {
            size = returnString(s);
            System.out.println(size.lines().count());
            try {
                while (size.readLine() != null) {
                    lines++;
                }
            } catch (IOException e) {
            }
        }
        return lines;
    }

    public static BufferedReader returnString(String fileName) {
        BufferedReader reader;

        try {
             reader = new BufferedReader(new FileReader(fileName));

            result = reader;
        } catch (IOException e) {
            e.printStackTrace();
        }

       return result;
    }


    private static List<String> getJavaFilesPaths(String dirName) {
        File directoryPath = new File(dirName);
        File[] filesList = directoryPath.listFiles();
        List<String> filePaths = new ArrayList<>();

        if (filesList != null) {
            for (File file : filesList) {
                filePaths.add(file.getAbsolutePath());
            }
        }
        return filePaths;
    }

    public static void main(String[] args) {

count("");
    }
}
