package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<JmeterLog> jmeters = JmeterLog.findAll();
        render(jmeters);
    }
    
    public static void upload(String label,File uploadFile){
       // List<Log> logs = new Parser(uploadFile,label).getLogs();
        JmeterLog jmeter = new JmeterLog(label);
        List<Data> data = new Parser(uploadFile,label).getData();
        //List<Data> data = new ArrayList<Data>();
        /*for(Log log:logs){
        	//jmeter.setData(new ArrayList<Data>(new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency())));
        	data.add(new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency()));
        	//new JmeterLog(label, new Data(log.getTimestamp(), log.getElapsed(), log.getLabel(), log.getSuccess(), log.getBytes(), log.getThreads(), log.getLatency())).save();
        	
        
        } */
            jmeter.setData(data);
            jmeter.save();
            redirect("/");
    }
    
    
    public static void jmeterJson(String name) {
        JmeterLog jmeters = JmeterLog.findById(name);
        List<Data> data = jmeters.getData();
        renderJSON(data);
      
        
    }
    
    public static void info(String name){
    	render(name);
    }

}