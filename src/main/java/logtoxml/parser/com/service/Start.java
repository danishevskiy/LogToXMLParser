package logtoxml.parser.com.service;

import logtoxml.parser.com.parser.JaxbParser;
import logtoxml.parser.com.parser.impl.LogParserImpl;
import logtoxml.parser.com.parser.impl.JaxbParserImpl;
import logtoxml.parser.com.reader.FileReader;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Андрей on 09.06.2017.
 */
public class Start {
    private static String regex = "(.*)\\|(.*)\\|(SdlSig|Stopping).*\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)";
    private static String s1 = "Задайте путь в к log.txt в виде полного пути";
    public static String s2 = "d://Output.xml";
    private static JaxbParser parser;
    private static File file;
    public static List<String> lines;

    public void start(String[] sArr){

        Service service = new Service();

        parser = new JaxbParserImpl();
        file = new File(s2);

        //проверка на наличие аргументов
        if (service.isPathAvailability(sArr)){
            //путь к лог файлу
            String src = sArr[0];

            FileReader reader = new FileReader();

            try {
                lines = reader.read(src);
            }catch (IOException e){
                System.out.println(e);
            }

            LogParserImpl logParser = new LogParserImpl();

            Pattern pattern = logParser.logParsing(regex);

            service.createMessage(service, pattern, lines);

            try {
                parser.saveObjects(file, service.getMessages());
            }catch (IOException e){
                System.out.println(e);
            }catch (JAXBException e){
                System.out.println(e);
            }

            System.out.println("finish");
        }else {
            System.out.println(s1);
        }

    }

}
