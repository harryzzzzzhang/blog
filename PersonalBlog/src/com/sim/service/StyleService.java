package com.sim.service;

import java.util.List;

import com.sim.Dao.StyleDao;
import com.sim.model.Style;

public class StyleService {

	public Style addStyle(Style style) {
		StyleDao dao=new StyleDao();
		Style newStyle=dao.addStyle(style);
		return newStyle;
	}
	
	public Style findStyle(String style) {
		StyleDao dao=new StyleDao();
		return dao.findStyle(style);
	}
	
	public List<Style> findAll(){
		StyleDao dao=new StyleDao();
		return dao.findAllStyle();
	}
	
	public Style deleteStyle(Style style) {
		StyleDao dao=new StyleDao();
		Style newStyle=dao.deleteStyle(style);
		return newStyle;
	}
}
