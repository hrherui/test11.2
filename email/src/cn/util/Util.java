package cn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Util {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pr=null;
	int math;
	public Connection getConnection(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/smbms","root","12345");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
	}
	public ResultSet executeQuery(String sql){
		try {
			pr=getConnection().prepareStatement(sql);
			rs=pr.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;	
	}
	public int executeUpdate(String sql,Object[] obj){
		try {
			pr=getConnection().prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				pr.setObject(i+1,obj[i]);
			}
			math=pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return math;
	}
	public void closeAll(){
	
		try {
			if(rs!=null){
			rs.close();
			}
			if(pr!=null){
				pr.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
