package controllers;

import play.*;
import play.mvc.*;

import java.io.*;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void upload(String label,File uploadFile){
        //uploadFile = new File();
        List<Log> logs = new Parser(uploadFile,label).getLogs();
        //String result = reader(uploadFile);
        //String name =   logs.get(2).getName();
        render(label,logs);
    }
    
    /*private static String reader(File file){
        int ch;
        StringBuffer strContent = new StringBuffer("");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            while ((ch = fin.read()) != -1)
                strContent.append((char) ch);
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return  strContent.toString();
    }   */
}