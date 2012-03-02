package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.util.*;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.google.code.morphia.Key;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<JmeterLog> jmeters = JmeterLog.findAll();
    	notFoundIfNull(jmeters);
        render(jmeters);
    }
    
    public static void upload(String label,File uploadFile){
        List<Log> logs = new Parser(uploadFile,label).getLogs();
       // JmeterLog jmeter = new JmeterLog(label);
        JmeterLog name = new JmeterLog(label);
        name.save();
        //List<Data> data = new Parser(uploadFile,label).getData();
        //List<Data> data = new ArrayList<Data>();
       // List<Data> data = new ArrayList<Data>();
        for(Log log:logs){
        	new Data(name,log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency()).save();
        	//jmeter.setData(new ArrayList<Data>(new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency())));
        	//data.add(new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency()));
        	//new JmeterLog(log.getName(), new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency())).save();
        	
        
        } 
             
            //jmeter.setData(data);
            
           // name.save();
            redirect("/");
    }
    
    
    public static void jmeterJson(String name) {
    	notFoundIfNull(name);
        //List<JmeterLog> jmeters = JmeterLog.q().findBy("nameTest",name).asList();
    	Key<JmeterLog> log = JmeterLog.find("nameTest", name).getKey();
    	List<Data> data = Data.find("name", log).asList();

    	//Object id = JmeterLog.find("nameTest", name).getKey().getId();
    	//notFoundIfNull(id);
    	//List<Data> data = Data.find("name", id).asList();
       // List<Data> data = jmeters.getData();
        renderJSON(data);
    }
    
    
    public static void vusers(String name){
    	Gson gson = new Gson();
    	Key<JmeterLog> log = JmeterLog.find("nameTest", name).getKey();
    	List<Data> data = Data.find("name", log).asList();
    	List<Vusers> vuser = new ArrayList<Vusers>();
    	StringBuffer buf = new StringBuffer();
    	buf.append("[");
    	boolean first = true;
    	for(Data dt : data){
    		//vuser.add(new Vusers(dt.timestamp, dt.threads));
    		if(!first){
        			buf.append(",");
        			first=false;
        		}
        		 buf.append("["+dt.timestamp+", "+dt.threads+"]");
        	
        	}
             buf.append("]");
    	
    	//for(Vusers vus: vuser){
    		//if(!first){
    		//	buf.append(",");
    		//	first=false;
    	//	}
    		// buf.append("["+vus.time+", "+vus.threads+"]");
    	
    	//}
    	//buf.append("]");
    	
    	//JsonArray ar = new JsonArray();
    	//ar.add(element)
    	//String json = gson.toJson(buf.toString());
    	
    	//JsonArray arr = json.g
    	//JsonParser parser = new JsonParser();
    	//JsonArray array = parser.parse(json).getAsJsonArray();
    	//JsonElement elem = gson.toJsonTree(vuser);
    	renderJSON(buf.toString());
    }
    
    public static void info(String name){
    	render(name);
    }

}