package web_erp.service;

import java.sql.Connection;
import java.util.List;

import web_erp.dao.impl.TitleDaoImpl;
import web_erp.ds.JndiDs;
import web_erp.dto.Title;

public class TitleService {
	private Connection con = JndiDs.getConnection();
	private TitleDaoImpl dao = TitleDaoImpl.getInstance();
	
	public TitleService() {
		dao.setCon(con);
	}
	
	public List<Title> showTitles(){
		return dao.selectTitleByAll();
	}
	
	public void addTitle(Title title) {
		dao.insertTitle(title);
	}
	
	public Title showTitle(Title title) {
		return dao.selectTitleByNo(title);
	}

	public int delTitle(int titleNo) {
		return dao.deleteTitle(titleNo);		
	}
	
	
	
}
