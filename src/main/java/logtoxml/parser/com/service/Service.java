package logtoxml.parser.com.service;

import logtoxml.parser.com.entity.Message;
import logtoxml.parser.com.entity.SDLMessage;
import logtoxml.parser.com.entity.StoppingMessage;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Андрей on 08.06.2017.
 */
public class Service {

    public static List<Message> messages = new ArrayList<>();
    private List<Object> objectList;
    private Matcher matcher;

    public boolean isPathAvailability(String[] sArr) {
        System.out.println(sArr.length);
        if (sArr.length < 1) {
            return false;
        }
        if (sArr.length > 0) {
            for (String s : sArr) {
                System.out.println(s);
                return true;
            }
        }
        return false;
    }

    public List<Message> createSdl(Matcher matcher){
        SDLMessage sdlMessage = new SDLMessage();
        sdlMessage.setUniqueLineSequenceTimestamp(matcher.group(1));
        sdlMessage.setDate(matcher.group(2));
        sdlMessage.setType(matcher.group(3));
        sdlMessage.setProcessName(matcher.group(4));
        sdlMessage.setCondition(matcher.group(5));
        sdlMessage.setDestination(matcher.group(6));
        sdlMessage.setSource(matcher.group(7));
        sdlMessage.setParameter1(matcher.group(8));
        sdlMessage.setParameter2(matcher.group(9));
        messages.add(sdlMessage);
        return messages;
    }

    public List<Message> createStopping(Matcher matcher) {
        StoppingMessage stoppingMessage = new StoppingMessage();
        stoppingMessage.setUniqueLineSequenceTimestamp(matcher.group(1));
        stoppingMessage.setDate(matcher.group(2));
        stoppingMessage.setType(matcher.group(3));
        stoppingMessage.setDestination(matcher.group(6));
        stoppingMessage.setSource(matcher.group(7));
        stoppingMessage.setAddInfo2(matcher.group(9));
        messages.add(stoppingMessage);
        return messages;

    }

    public List<Object> getMessages() {
        objectList = new ArrayList<>();
        for(Message m : messages)
            objectList.add(m);
        return objectList;
    }

    public void createMessage(Service service, Pattern pattern, List<String> lines){
        for (String s : lines){
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                String s3 = matcher.group(3);
                if (s3.equals("SdlSig")) {
                    System.out.println("createSdl");
                    service.createSdl(matcher);
                }
                if (s3.equals("Stopping")) {
                    System.out.println("createStopping");
                    service.createStopping(matcher);
                }
            }
        }
    }

}
