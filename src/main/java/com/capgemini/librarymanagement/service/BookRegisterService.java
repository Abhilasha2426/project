package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.dto.BookRegister;

public interface BookRegisterService {
	public BookRegister updateRegister(int registerId, BookRegister bookRegister );
	public boolean deleteRegister(int registerId);
	public boolean addRegister(BookRegister bookRegister);
	public BookRegister searchRegister(int registerId);

}
