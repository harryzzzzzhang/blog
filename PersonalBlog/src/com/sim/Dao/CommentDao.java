package com.sim.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sim.common.DbObject;
import com.sim.model.Comment;

public class CommentDao {

	public CommentDao() {
		
	}
	
	public Comment addComment(Comment comment) {
		String sql="insert into comment(commentContent, title, userEmail) values(?,?,?)";
		DbObject.executeUpdate(sql, comment.getCommentContent(), comment.getTitle(), comment.getUserEmail());
		return comment;
	}
	
	public Comment findExistsCommentByTitle(String title){
		String sql="select * from comment where title=?";
		
		ResultSet rs = null;
		Comment comment=null;
		
		try {
			rs = DbObject.executeQuery(sql, title);
			if (rs.next()) {
				comment = new Comment();
				
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentId(rs.getInt("commentId"));
				comment.setCommentTime(rs.getString("commentTime"));
				comment.setCommentState(rs.getString("commentState"));
				comment.setTitle(rs.getString("title"));
				comment.setUserEmail(rs.getString("userEmail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbObject.close(null,null,rs);
		}
		return comment;
	}
	
	public List<Comment> findCommentByTitle(String title){
		String sql="select * from comment where title=?";
		ResultSet rs = null;
		Comment comment=null;
		
		List<Comment> list=new ArrayList<Comment>();
		
		rs = DbObject.executeQuery(sql,title);
		try {
			while (rs.next()) {
			comment = new Comment();
			
			comment.setCommentContent(rs.getString("commentContent"));
			comment.setCommentId(rs.getInt("commentId"));
			comment.setCommentTime(rs.getString("commentTime"));
			comment.setCommentState(rs.getString("commentState"));
			comment.setTitle(rs.getString("title"));
			comment.setUserEmail(rs.getString("userEmail"));
			
			list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DbObject.close(null,null,rs);
		}
		return list;
	}
}
