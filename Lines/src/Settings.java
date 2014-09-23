import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by OverMind on 16.05.14.
 */
public class Settings {
    Path path = Paths.get("scores.txt");
    Properties properties = new Properties();
    int highScores;

    public Settings() {

        try (InputStream in = new BufferedInputStream(new FileInputStream(path.toString()))){
            properties.load(in);
            highScores = Integer.parseInt(properties.getProperty("scores"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getHighScores(){
        return highScores;

    }
}
