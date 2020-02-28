package com.capgemini.librarymanagement.dao;

import java.util.Iterator;

import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookRegister;

public class BookRegisterDaoImpl implements BookRegisterDao {

	public BookRegister updateRegister(int registerId, BookRegister bookRegister) {
		BookRegister bRegister;
		Iterator<BookRegister> itr = DbStore1.bookRegisters.iterator();
		while (itr.hasNext()) {
			bRegister = itr.next();
			if(bRegister.getRegisterId()!=bookRegister.getRegisterId() ) {
				bRegister.setRegisterId(bookRegister.getRegisterId());
				bRegister.setBookId(bRegister.getBookId());
				bRegister.setUserId(bRegister.getUserId());
				bRegister.setRegisterDate(bRegister.getRegisterDate());
				return bRegister;
				
			}else {
				return null;
			}
		}
		return bookRegister;
	}

	public boolean deleteRegister(int registerId) {
		Iterator<BookRegister> itr=DbStore1.bookRegisters.iterator();
		while(itr.hasNext()) {
			BookRegister book=itr.next();
			if(book.getRegisterId()==registerId) {
				DbStore1.bookRegisters.remove(book);
				return true;
			}
		}
		return false;
	}

		
		
	public boolean addRegister(BookRegister bookRegister) {
		System.out.println(bookRegister);
		DbStore1.bookRegisters.add(bookRegister);
		return true;
		
	}

	public BookRegister searchRegister(int registerId) {
		return null;
	}

}
