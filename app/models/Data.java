package models;

import com.google.code.morphia.annotations.Embedded;

/**
 * Created by IntelliJ IDEA.
 * User: Siarhei_Melnik
 * Date: 3/1/12
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */

@Embedded
public class Data {
	private String timestamp;
    public String elapsed;
    public String label;
    public String success;
    public String bytes;
    public String threads;
    public String latency;

	public Data(String timestamp, String elapsed, String label, String success,
			String bytes, String threads, String latency) {

		this.timestamp = timestamp;
		this.elapsed = elapsed;
		this.label = label;
		this.success = success;
		this.bytes = bytes;
		this.threads = threads;
		this.latency = latency;
	}
	/*public String getTimestamp() {
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
	}*/
	
	
    
    
    


}
