package com.sim.service;

import java.util.List;

import com.sim.Dao.PassageDao;
import com.sim.model.Passage;

public class PassageService {

	public Passage addPassage(Passage passage) {
		PassageDao dao=new PassageDao();
		Passage newPassage=dao.addPassage(passage);
		return newPassage;
	}
	
	public Passage updatePassage(Passage passage) {
		PassageDao dao=new PassageDao();
		Passage newPassage=dao.updatePassage(passage);
		return newPassage;
	}
	
	public Passage deletePassage(Passage passage) {
		PassageDao dao=new PassageDao();
		Passage newPassage=dao.deletePassage(passage);
		return newPassage;
	}
	
	public List<Passage> findPassageByUserEmail(String userEmail) {
		PassageDao dao=new PassageDao();
		return dao.findPassageByUserEmail(userEmail);
	}
	
	public List<Passage> findLikeTitlePassage(String likeTitle) {
		PassageDao dao=new PassageDao();
		return dao.findLikeTitlePassage(likeTitle);
	}
	
	public List<Passage> findAllTitlePassage(){
		PassageDao dao=new PassageDao();
		return dao.findAllTitlePassage();
	}
	
	public Passage findPassageByTitle(String title) {
		PassageDao dao=new PassageDao();
		return dao.findPassageByTitle(title);
	}
	
	public List<Passage> findMovieStylePassage() {
		PassageDao dao=new PassageDao();
		return dao.findMovieStylePassage();
	}
	
	public List<Passage> findBooksStylePassage() {
		PassageDao dao=new PassageDao();
		return dao.findBooksStylePassage();
	}
	
	public List<Passage> findMusicStylePassage() {
		PassageDao dao=new PassageDao();
		return dao.findMusicStylePassage();
	}
}
