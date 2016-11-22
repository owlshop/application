package owlshop.model;

import java.sql.*;

public class Connections {
	
	private static final String DATABASE = "CONFIDENTIAL";
	private static final String USERNAME = "CONFIDENTIAL";
	private static final String PASSWORD = "CONFIDENTIAL";
	
	public Connection getConnection(){
        try{;
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DATABASE,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
