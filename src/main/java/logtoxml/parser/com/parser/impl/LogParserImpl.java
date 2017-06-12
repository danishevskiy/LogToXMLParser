package logtoxml.parser.com.parser.impl;

import logtoxml.parser.com.parser.LogParser;

import java.util.regex.Pattern;

/**
 * Created by Андрей on 09.06.2017.
 */
public class LogParserImpl implements LogParser {

    private Pattern pattern;

    public Pattern logParsing(String regex){
        pattern = Pattern.compile(regex);
        return pattern;
    }
}
