package com.sim.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sim.common.DbObject;
import com.sim.model.Style;
import com.sim.model.User;

public class StyleDao {

	public StyleDao(){
		
	}
	
	public Style addStyle(Style style) {
		String sql="insert into style values(?)";
		DbObject.executeUpdate(sql, style.getStyle());
		return style;
	}
	
	public Style findStyle(String style2) {
		String sql = "select * from style where style=?";
		ResultSet rs = null;

		Style style=null;
		try {
			rs = DbObject.executeQuery(sql, style2);
			if (rs.next()) {
				style=new Style();
				style.setStyle(rs.getString("style"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return style;
	}
	
	public List<Style> findAllStyle(){
		String sql="select * from style";
		ResultSet rs=null;
		
		Style style=null;
		
		List<Style> list=new ArrayList<Style>();
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				style=new Style();
				style.setStyle(rs.getString("style"));
				list.add(style);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public Style deleteStyle(Style style) {
		String sql="delete style where style=?";
		DbObject.executeUpdate(sql, style.getStyle());
		return style;
	}
}
