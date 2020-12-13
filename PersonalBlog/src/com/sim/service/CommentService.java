package com.sim.service;

import java.util.List;

import com.sim.Dao.CommentDao;
import com.sim.model.Comment;

public class CommentService {

	public Comment addComment(Comment comment) {
		CommentDao dao=new CommentDao();
		Comment newComment=dao.addComment(comment);
		return newComment;
	}
	
	public Comment findExistsCommentByTitle(String title) {
		CommentDao dao=new CommentDao();
		return dao.findExistsCommentByTitle(title);
	}
	
	public boolean existsComment(String title) {
		Comment comment=this.findExistsCommentByTitle(title);
		if(comment==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<Comment> findCommentByTitle(String title){
		CommentDao dao=new CommentDao();
		return dao.findCommentByTitle(title);
	}
}
