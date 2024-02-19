package buontyhunter.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileProvider {

    /**
     * Load a text file from the assets folder
     * 
     * @param path the path to the text file
     * @return the text file content if it was loaded successfully, Optional.empty()
     *         otherwise
     */
    public Optional<String> getText(String path) {
        try (InputStream is = getClass().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return Optional.of(reader.lines().collect(Collectors.joining("\n")));
        } catch (Exception e) {

            System.out.println("Failed to load text: " + path + " error Message => " + e);
            // e.printStackTrace();
            return Optional.empty();
        }
    }
}
