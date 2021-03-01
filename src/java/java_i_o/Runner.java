import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("output.txt");
        File path = new File(args[0]);
        try {
            if (args[0].contains(".txt")) {
                file = new File(args[0]);
                ReaderUtil.fileScanner(file);
            } else {
                file.delete();
                if (!path.exists()) {
                    System.out.println(args[0] + " file doesn`t exist");
                    return;
                }
                WriterUtil.pathPrint(path, "");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
