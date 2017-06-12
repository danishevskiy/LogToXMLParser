package logtoxml.parser.com.parser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Андрей on 08.06.2017.
 */
public interface JaxbParser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObjects(File file, List<Object> objects) throws JAXBException, IOException;
}
