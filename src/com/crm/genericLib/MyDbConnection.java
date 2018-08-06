package com.crm.genericLib;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class MyDbConnection {

	public static void main(String[] args) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://192.168.0.109:3306/"+"studentsapp_db","j2ee","j2ee");
		
		java.sql.Statement stat=conn.createStatement();
		
		ResultSet rs=stat.executeQuery("Select *from employee");
		
		while (rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
conn.close();
	}

}
