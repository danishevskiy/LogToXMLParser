package logtoxml.parser.com.parser;

import java.util.regex.Pattern;

/**
 * Created by Андрей on 09.06.2017.
 */
public interface LogParser {

    public Pattern logParsing(String regex);
}
