package com.capgemini.librarymanagement.db;

import java.util.LinkedList;

import com.capgemini.librarymanagement.dao.BookInfoTransaction;
import com.capgemini.librarymanagement.dto.AdminInfoBean;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.BookRegister;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class DbStore1 {
	public static LinkedList<AdminInfoBean> adminInfoBeans=new LinkedList<AdminInfoBean>();
	public static LinkedList<BookInfo> bookInfo=new LinkedList<BookInfo>();
	public static LinkedList<UserInfoBean> userInfoBean=new LinkedList<UserInfoBean>();
	public static LinkedList<BookRegister> bookRegisters = new LinkedList<BookRegister>();
	public static LinkedList<BookInfoTransaction> bookInfoTransactions=new LinkedList<BookInfoTransaction>();
	
}
