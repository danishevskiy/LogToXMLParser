package logtoxml.parser.com.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Андрей on 08.06.2017.
 *
 * Discusses the components of the less-used Signal Distribution
 * Layer (SDL) trace files in CallManager. SDL traces describe the events occurring in
 * the CallManager software at a code level. These traces are usually reserved for Cisco
 * development engineering use; however, there are a few key pieces of information you
 * can use to your advantage when troubleshooting CallManager problems.
 */
@XmlRootElement(name = "SDLMassage")
@XmlType(propOrder = {"uniqueLineSequenceTimestamp", "date", "type", "processName", "condition",
        "destination", "source", "parameter1", "parameter2"})
public class SDLMessage implements Message {

    /**
     * Represents a unique line sequence timestamp
     */
    private String uniqueLineSequenceTimestamp;

    /**
     * Represents the date(yy/mm/dd-hh:mm:ss:vvv)
     * yy represents the year
     * mm represents the month
     * dd represents the day
     * hh represents the hour
     * mm represents the minutes
     * ss represents the seconds
     * vvv represents the milliseconds
     */
    private String date;

    /**
     * Represents the log entry type (which defines the type of entry being logged)
     */
    private String type;

    /**
     * The value is the process name.
      */
    private String processName;

    /**
     * The value is initialized or wait or restart0
     */
    private String condition;

    /**
     * The value shows the destination (Db(x,xxx,xxx,x)).
     * These describe the process sending the signal and the process to which
     * the signal is being sent.
     * The four numbers represent (in this order)
     *  • Node number
     *  • Application number (100 = CallManager, 200 = CTI Manager)
     *  • Process type
     *  • Process instance
     */
    private String destination;

    /**
     * The value shows the source (Db(x,xxx,xxx,x).
     * These describe the process sending the signal and the process to which
     * the signal is being sent.
     * The four numbers represent (in this order)
     *  • Node number
     *  • Application number (100 = CallManager, 200 = CTI Manager)
     *  • Process type
     *  • Process instance
     */
    private String source;

    private String parameter1;

    private String parameter2;

    public String getUniqueLineSequenceTimestamp() {
        return uniqueLineSequenceTimestamp;
    }

    @XmlElement
    public void setUniqueLineSequenceTimestamp(String uniqueLineSequenceTimestamp) {
        this.uniqueLineSequenceTimestamp = uniqueLineSequenceTimestamp;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String type) {
        this.type = type;
    }

    public String getProcessName() {
        return processName;
    }

    @XmlElement
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getCondition() {
        return condition;
    }

    @XmlElement
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDestination() {
        return destination;
    }

    @XmlElement
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    @XmlElement
    public void setSource(String source) {
        this.source = source;
    }

    public String getParameter1() {
        return parameter1;
    }

    @XmlElement
    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    @XmlElement
    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    @Override
    public String toString() {
        return "&ltSDL&gt" + "<br>" + "&nbsp" +
                "&ltuniqueLineSequenceTimestamp&gt" + uniqueLineSequenceTimestamp + "&lt/uniqueLineSequenceTimestamp&gt"
                + "<br>" + "&nbsp" +
                "&ltdate&gt" + date + "&lt/date&gt" + "<br>" + "&nbsp" +
                "&lttype&gt" + type + "&lt/type&gt" + "<br>" + "&nbsp" +
                "&ltprocessName&gt" + processName + "&lt/processName&gt" + "<br>" + "&nbsp" +
                "&ltcondition&gt" + condition + "&lt/condition&gt" + "<br>" + "&nbsp" +
                "&ltdestination&gt" + destination + "&lt/destination&gt" + "<br>" + "&nbsp" +
                "&ltsource&gt" + source + "&lt/source&gt" + "<br>" + "&nbsp" +
                "&ltparameter1&gt" + parameter1 + "&lt/parameter1&gt" + "<br>" + "&nbsp" +
                "&ltparameter2&gt" + parameter2 + "&lt/parameter2&gt" + "<br>" + "&nbsp" +
                "&lt/SDL&gt";
    }
}
