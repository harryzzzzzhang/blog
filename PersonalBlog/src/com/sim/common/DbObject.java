package com.sim.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class DbObject {
	public static Connection getConnection(){
		Connection cn=null;
		
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;database=PersonalBlog";
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url,"sa","sa");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("找不到合适的数据库驱动"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("不能连接数据库"+e.getMessage());
		}
		return cn;
	}

	public static void close(Connection cn, PreparedStatement st, ResultSet rs){
		try{
		if(rs!=null) {
			rs.close();
		}
		if(st!=null) {
			st.close();
		}
		if(cn!=null) {
			cn.close();
		} 
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	public static int executeUpdate(String sql, Object... param){
		
		Connection cn=getConnection();
		PreparedStatement st=null;
		int ret=0;
		try {
			st=cn.prepareCall(sql);
			
			for (int i=0; i<param.length; i++){
				st.setObject(i+1, param[i]);
			}
			ret = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(cn, st, null);
		}
		return ret;
	}
	
	public static ResultSet executeQuery(String sql, Object... param) {
		Connection cn=getConnection();
		PreparedStatement st=null;
		ResultSet rs=null;
		
		CachedRowSet crs=null;
		try {
			st=cn.prepareCall(sql);
			for (int i=0; i<param.length; i++){
				st.setObject(i+1, param[i]);
			}
			rs = st.executeQuery();
			
			crs= RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(cn, st, rs);
		}
		return crs;
	}
}

