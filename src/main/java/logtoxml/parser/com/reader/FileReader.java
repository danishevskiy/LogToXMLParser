package logtoxml.parser.com.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Андрей on 09.06.2017.
 */
public class FileReader {

    private List<String> lines;

    public List<String> read(String s) throws IOException {
        lines = Files.readAllLines(Paths.get(s), StandardCharsets.UTF_8);
        return lines;
    }


}
