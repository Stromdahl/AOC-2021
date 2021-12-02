import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class helper {
    static String[] readFile(String filename) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            return null;
        }

        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        return lines.toArray(new String[0]);
    }
}
