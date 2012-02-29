package models;

/**
 * Created by IntelliJ IDEA.
 * User: Siarhei_Melnik
 * Date: 2/29/12
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Log  {
    private String name;
    private String timestamp;
    private String elapsed;
    private String label;
    private String success;
    private String bytes;
    private String threads;
    private String latency;
    
    
    
    public Log(String name,String timestamp,String elapsed,String label,String success,String bytes,String threads,String latency){
        setName(name);
        setTimestamp(timestamp);
        setElapsed(elapsed);
        setLabel(label);
        setSuccess(success);
        setBytes(bytes);
        setThreads(threads);
        setLatency(latency);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    public String getThreads() {
        return threads;
    }

    public void setThreads(String threads) {
        this.threads = threads;
    }

    public String getLatency() {
        return latency;
    }

    public void setLatency(String latency) {
        this.latency = latency;
    }
}
