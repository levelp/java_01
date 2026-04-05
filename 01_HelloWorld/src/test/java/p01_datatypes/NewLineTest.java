package p01_datatypes;

import java.util.HashMap;
import java.util.Map;

// Перевод строки на разных платформах
// -----------------------------------
public class NewLineTest {

    static Map<Integer, String> charNames = new HashMap<>();

    static {
        // ASCII код 10 - LF - \n - перевод строки
        charNames.put(10, "LF - Line Feed");
        // ASCII код 13 - CR - \r - возврат каретки
        charNames.put(13, "CR - Carriage Return");
    }

    public static void main(String[] args) {
        System.out.println("\\n");
        show("\n");  // \n - 0 10  - LF
        System.out.println("\\r\\n");
        show("\r\n"); // \r\n - 0 13 CR + 1 10 LF
        System.out.println("\\r");
        show("\r"); // \r - 0 13 CR
        System.out.println("%n");
        show(String.format("%n")); // %n - Windows: 0 13 CR + 1 10 LF
        // MacOSX: 0 10 LF
        show(System.getProperty("line.separator"));
        // Windows: 0 13 CR + 1 10 LF
        // MacOSX: 0 10 LF
    }

    private static void show(String res) {
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            System.out.println(i + " " + (int) c + " " + charNames.get((int) c));
        }
        System.out.println("\"" + res + "\"");
    }
}
