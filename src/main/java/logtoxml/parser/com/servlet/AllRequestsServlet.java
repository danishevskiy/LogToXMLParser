package logtoxml.parser.com.servlet;

import logtoxml.parser.com.entity.Message;
import logtoxml.parser.com.service.Service;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 */
public class AllRequestsServlet extends HttpServlet{

    private String outer = " ";
    private List<Message> messages = Service.messages;
    private static final String s0 = "Pleas, wait!";
    private static final String s1 = "Here is a fragment of data (10 first logs) ";
    private static final String s2 = "Output.xml is on disk D (\"d://Output.xml\")";
    private static final String s3 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        if(messages.size() == 0){
            response.getWriter().println(s0);
        }
        else {
            response.getWriter().println(s1 + "<br>" + s2 + "<br>");

            messages = Service.messages;

            out.println(s3);

            for (int i = 0; i < 10; i++)
                outer = outer + messages.get(i).toString() + "<br>";
            /*for (Message m : messages)
                outer = outer + m.toString() + "<br>";*/
            out.println(outer);
            response.getWriter().println(s2 + "<br>");
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
