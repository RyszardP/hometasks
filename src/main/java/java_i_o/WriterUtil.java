

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterUtil {
    static final String FOLDER_NODE = "|---";

    public static void pathPrint(File path, String space) {
        File[] node = path.listFiles();
        if (node != null) {
            for (int i = 0; i < node.length; i++) {
                if (node[i].isDirectory()) {
                    System.out.print("|");
                    System.out.println(space + FOLDER_NODE + node[i].getName());
                    writeToFile(space + FOLDER_NODE + node[i].getName());
                    pathPrint(node[i], space + "    ");
                } else {
                    System.out.print("|");
                    System.out.println(space + "" + node[i].getName());
                    writeToFile(space + "" + node[i].getName());
                }
            }
        }
    }


    private static void writeToFile(String fileName) {
        File file = new File("output.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(fileName + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
