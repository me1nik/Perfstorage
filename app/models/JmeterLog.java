package models;


import play.modules.morphia.Model;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Embedded;

import java.util.List;

import org.bson.types.ObjectId;

/**
 * Created by IntelliJ IDEA.
 * User: Siarhei_Melnik
 * Date: 3/1/12
 * Time: 3:11 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity("jmeter")
public class JmeterLog extends Model {
   
   //public ObjectId id;
   @Id
   public String nameTest;
   @Embedded
   public List<Data> data;
   
   public JmeterLog(String nameTest){
	   this.nameTest = nameTest;
	  // this.data = data;
   }
   
   public void setData(List<Data> data){
	   this.data = data;
   }

   public List<Data> getData() {
	return data;
   }
   	
  
   
/*public JmeterLog(String nameTest, Data data) {
	
	this.nameTest = nameTest;
	this.data = data;
}


public ObjectId getId() {
	return id;
}
public void setId(ObjectId id) {
	this.id = id;
}
public String getNameTest() {
	return nameTest;
}
public void setNameTest(String nameTest) {
	this.nameTest = nameTest;
}
public Data getData() {
	return data;
}
public void setData(Data data) {
	this.data = data;
}*/
   
   




}
