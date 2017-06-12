package logtoxml.parser.com.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Андрей on 08.06.2017.
 */
@XmlRootElement(name = "Stopping")
@XmlType(propOrder = {"uniqueLineSequenceTimestamp", "date", "type", "destination", "source", "addInfo2"})
public class StoppingMessage implements Message {
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

    private String addInfo1;

    private String addInfo2;

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

    public String getAddInfo2() {
        return addInfo2;
    }

    @XmlElement
    public void setAddInfo2(String addInfo2) {
        this.addInfo2 = addInfo2;
    }

    @Override
    public String toString() {
        return "&ltStoppingMassage&gt" + "<br>" + "&nbsp" +
                "&ltuniqueLineSequenceTimestamp&gt" + uniqueLineSequenceTimestamp + "&lt/uniqueLineSequenceTimestamp>" +
                "<br>" + "&nbsp" +
                "&ltdate&gt" + date + "&lt/date&gt" + "<br>" + "&nbsp" +
                "&lttype&gt" + type + "&lt/type&gt" + "<br>" + "&nbsp" +
                "&ltprocessName&gt" + processName + "&lt/processName>" + "<br>" + "&nbsp" +
                "&ltcondition&gt" + condition + "&lt/condition>" + "<br>" + "&nbsp" +
                "&ltdestination&gt" + destination + "&lt/destination>" + "<br>" + "&nbsp" +
                "&ltsource&gt" + source + "&lt/source&gt" + "<br>" + "&nbsp" +
                "&ltaddInfo1&gt" + addInfo1 + "&lt/addInfo1&gt" + "<br>" + "&nbsp" +
                "&ltaddInfo2&gt" + addInfo2 + "&lt/addInfo2&gt"  + "<br>" + "&nbsp" +
                "&lt/StoppingMassage&gt";
    }
}
