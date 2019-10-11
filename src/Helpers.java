import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helpers {

    public static String readFile(String fileName) {
        String stringContent = "";
        try
        {
            stringContent = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stringContent;
    }

}
