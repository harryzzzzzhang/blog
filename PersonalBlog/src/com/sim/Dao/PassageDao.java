package com.sim.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sim.common.DbObject;
import com.sim.model.Passage;

public class PassageDao {

	public PassageDao(){
		
	}
	
	public Passage addPassage(Passage passage) {
		String sql="insert into passage(title, content, style, userEmail) values(?,?,?,?)";
		DbObject.executeUpdate(sql, passage.getTitle(), passage.getContent(), passage.getStyle(), passage.getUserEmail());
		return passage;
	}
	
	public Passage updatePassage(Passage passage) {
		String sql="update passage set title=?, content=?, updateTime=getDate() where title=?";
		DbObject.executeUpdate(sql, passage.getTitle(), passage.getContent(), passage.getTitle());
		return passage;
	}
	
	public Passage deletePassage(Passage passage) {
		String sql="delete passage where title=?";
		DbObject.executeUpdate(sql, passage.getTitle());
		return passage;
	}
	
	public List<Passage> findAllTitlePassage(){
		String sql = "select title, userNickname, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime from passage join userInformation on passage.userEmail=userInformation.userEmail";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				passage = new Passage();
				passage.setTitle(rs.getString("title"));
				passage.setUserEmail(rs.getString("userNickname"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public List<Passage> findPassageByUserEmail(String userEmail) {
		String sql = "select title, content, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime, userEmail from passage where userEmail=?";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		try {
			rs = DbObject.executeQuery(sql,userEmail);
			while (rs.next()) {
				passage = new Passage();
				
				passage.setTitle(rs.getString("title"));
				passage.setContent(rs.getString("content"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				passage.setUserEmail(rs.getString("userEmail"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public Passage findPassageByTitle(String title) {
		String sql = "select title, content, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updatetime,120) as updatetime, userEmail from passage where title=?";
		ResultSet rs = null;

		Passage passage = null;
		try {
			rs = DbObject.executeQuery(sql, title);
			if (rs.next()) {
				passage = new Passage();
				
				passage.setTitle(rs.getString("title"));
				passage.setContent(rs.getString("content"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				passage.setUserEmail(rs.getString("userEmail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return passage;
	}
	
	public List<Passage> findMovieStylePassage(){
		String sql = "select title, userNickname, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime from passage join userInformation on passage.userEmail=userInformation.userEmail where style='µÁ”∞'";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				passage = new Passage();
				passage.setTitle(rs.getString("title"));
				passage.setUserEmail(rs.getString("userNickname"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public List<Passage> findBooksStylePassage(){
		String sql = "select title, userNickname, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime from passage join userInformation on passage.userEmail=userInformation.userEmail where style='∂¡ È'";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				passage = new Passage();
				passage.setTitle(rs.getString("title"));
				passage.setUserEmail(rs.getString("userNickname"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public List<Passage> findMusicStylePassage(){
		String sql = "select title, userNickname, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime from passage join userInformation on passage.userEmail=userInformation.userEmail where style='“Ù¿÷'";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				passage = new Passage();
				passage.setTitle(rs.getString("title"));
				passage.setUserEmail(rs.getString("userNickname"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	public List<Passage> findLikeTitlePassage(String likeTitle){
		String sql = "select title, userNickname, style, Convert(VarChar(19),publishTime,120) as publishTime, Convert(VarChar(19),updateTime,120) as updateTime from passage join userInformation on passage.userEmail=userInformation.userEmail where title like '%"+likeTitle+"%'";
		ResultSet rs = null;
		Passage passage = null;
		
		List<Passage> list=new ArrayList<Passage>();
		
		try {
			rs = DbObject.executeQuery(sql);
			while (rs.next()) {
				passage = new Passage();
				passage.setTitle(rs.getString("title"));
				passage.setUserEmail(rs.getString("userNickname"));
				passage.setStyle(rs.getString("style"));
				passage.setPublishTime(rs.getString("publishTime"));
				passage.setUpdateTime(rs.getString("updateTime"));
				list.add(passage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
	
	
}
