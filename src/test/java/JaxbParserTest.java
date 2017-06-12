import org.junit.Before;
import org.junit.Test;
import logtoxml.parser.com.parser.JaxbParser;
import logtoxml.parser.com.parser.impl.JaxbParserImpl;
import logtoxml.parser.com.service.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Андрей on 08.06.2017.
 */
public class JaxbParserTest {
    private JaxbParser parser;
    private File file;

    @Before
    public void setUp() throws Exception {

        parser = new JaxbParserImpl();
        file = new File("d://SDLnnn.xml");
    }

    @Test
    public void testSaveObject() throws Exception {

        Service service = new Service();

        List<String> ls = new ArrayList<>();
        ls.add("[eq0000002446697.000 |13:42:41.011 |Stopping |                 |          " +
                " |SdlTCPConnector(1,100,13,86225)  |SdlTCPConnector(1,100,13,86225)  |" +
                "    |NumOfCurrentInstances: 1");

        String regex = "(.*)\\|(.*)\\|(SdlSig|Stopping).*\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)";
        Pattern pattern = Pattern.compile(regex);
        for (String s : ls) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                String s3 = matcher.group(3);
                System.out.println(s3);
                if (s3.equals("SdlSig")) {
                    service.createSdl(matcher);
                }
                if (s3.equals("Stopping")) {
                    service.createStopping(matcher);
                }
            }
            parser.saveObjects(file, service.getMessages());
            System.out.println("fin");
        }

    }
}