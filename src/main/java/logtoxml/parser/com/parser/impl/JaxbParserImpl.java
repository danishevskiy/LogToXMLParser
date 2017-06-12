package logtoxml.parser.com.parser.impl;

import logtoxml.parser.com.parser.JaxbParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

/**
 * Created by Андрей on 08.06.2017.
 */
public class JaxbParserImpl implements JaxbParser {
    private static final String s0 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
    private static final String s1 = "<Message>";
    private static final String s2 = "</Messages>";
    private String s = "Wait! The XML file is creating";

    @Override
    public Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);
        return object;
    }

    @Override
    public void saveObjects(File file, List<Object> objects) throws JAXBException, IOException {
        try(OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(s0.getBytes());
            outputStream.write(s1.getBytes());
            System.out.println(s);
            for (Object o: objects) {
                saveObject(outputStream, o);
            }
            outputStream.write(s2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveObject(OutputStream file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(o, file);
    }
}
