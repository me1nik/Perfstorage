package controllers;

import play.*;
import play.mvc.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void upload(String label,File uploadFile){
        //uploadFile = new File();
        String result = reader(uploadFile);

        render(label,result);
    }
    
    private static String reader(File file){
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
    }
}