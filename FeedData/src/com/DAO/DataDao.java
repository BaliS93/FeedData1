package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.POJO.Data;

public class DataDao {

	
	//registering to the class.
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Balaji93!");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	
	
	 public static int save(Data e){  
	        int status=0;  
	        try{  
	            Connection con=DataDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into DATA(FIRSTNAME,LASTNAME,CONTACTNO) values (?,?,?)");  
	           
	            
	            
	            
	            ps.setString(1,e.getFIRSTNAME());  
	            ps.setString(2,e.getLASTNAME());  
	            ps.setString(3,e.getCONTACTNO());  
	             
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	
	
	
	
	
}
