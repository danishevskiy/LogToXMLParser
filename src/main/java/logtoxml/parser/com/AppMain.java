package logtoxml.parser.com;

import logtoxml.parser.com.service.Start;
import logtoxml.parser.com.servlet.AllRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Андрей on 08.06.2017.
 */
public class AppMain {

    public static void main(String[] args) throws Exception {

        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("start");
                new Start().start(args);
            }
        };
        timer.schedule(timerTask, 0, 300000);

        server.join();




    }
}
