

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderUtil {

    public static void fileScanner(File file) throws IOException {
        int totalLengthOfFilesNames = 0;
        String line = "";
        List<String> folders = new ArrayList<>();
        List<String> files = new ArrayList<>();

        try (FileReader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("---")) {
                    line = line.substring(line.indexOf("-") + 3);
                    folders.add(line);
                } else {
                    line = line.replace('|', ' ');
                    line = line.trim();
                    if (line.toCharArray().length != 0) {
                        files.add(line);
                        totalLengthOfFilesNames += line.length();
                    }
                }
            }
            System.out.println("Folders quantity " + folders.size());
            System.out.println("Files quantity " + files.size());
            System.out.printf("Average quantity of files in folder: %.2f \n", (double) files.size() / folders.size());
            System.out.printf("Average file name length: %.2f \n", (double) totalLengthOfFilesNames / files.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}