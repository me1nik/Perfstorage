package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.util.*;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import com.google.code.morphia.Key;

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
    	
    	renderJSON(name);
    }
    
    public static void info(String name){
    	render(name);
    }

}