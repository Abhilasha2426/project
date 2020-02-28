package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.dao.BookRegisterDao;
import com.capgemini.librarymanagement.dao.BookRegisterDaoImpl;
import com.capgemini.librarymanagement.dto.BookRegister;


public class BookRegisterServiceImpl implements BookRegisterService{

	private BookRegisterDao dao=new BookRegisterDaoImpl();
	public BookRegister updateRegister(int registerId, BookRegister bookRegister) {
		return dao.updateRegister(registerId, bookRegister);
	}

	public boolean deleteRegister(int registerId) {
		return dao.deleteRegister(registerId);
	}

	public boolean addRegister(BookRegister bookRegister) {
		return dao.addRegister(bookRegister);
	}

	public BookRegister searchRegister(int registerId) {
		return dao.searchRegister(registerId);
	}

}
