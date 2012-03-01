package models;

import com.csvreader.CsvReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Siarhei_Melnik
 * Date: 2/29/12
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Parser {
    //private List<Log> Logs;
    private List<Data> data;
    public Parser(File file,String name){
        try {
            CsvReader reader = new CsvReader(new FileReader(file));
           // Logs = new ArrayList<Log>();
            data = new ArrayList<Data>();
            reader.readHeaders();
            while (reader.readRecord()){
                int i=0;
                String timestamp = reader.get("timeStamp");
                String elapsed = reader.get("elapsed");
                String label = reader.get("label");
                String success = reader.get("success");
                String bytes = reader.get("bytes");
                String threads = reader.get("allThreads");
                String latency = reader.get("Latency");
                //Logs.add(i,new Log(name,timestamp,elapsed,label,success,bytes,threads,latency));
                data.add(i, new Data(timestamp,elapsed,label,success,bytes,threads,latency));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   /* public List<Log> getLogs() {
        return Logs;
    }*/
    
    
    public void uploadToMongo(){
        //upload;)
    }

	public List<Data> getData() {
		return data;
	}
}
