package com.capgemini.librarymanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.LibraryMainPage;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.service.AdminBookService;
import com.capgemini.librarymanagement.service.AdminBookServiceImpl;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImpl;

public class LibraryManagementController {

	Scanner scanner = new Scanner(System.in);
	AdminBookService adminBookService = new AdminBookServiceImpl();
	UserService userService = new UserServiceImpl();

	public void admin() {

		System.out.println(" Admin Successfull login");
		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1.Add Book");
			System.out.println("2.Add User");
			System.out.println("3.Delete Book");
			System.out.println("4.Delete User");
			System.out.println("5.Show All Users");
			System.out.println("6.Show All Books");
			System.out.println("7.Update User Details");
			System.out.println("8.Logout");
			System.out.println("-------------------------");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter book id: ");
				int bookId = scanner.nextInt();
				System.out.println("Enter name of book");
				String bookName = scanner.next();
				System.out.println("Enter author name");
				String bookAuth = scanner.next();

				System.out.println("Enter no of books");
				int bookNum = scanner.nextInt();
				System.out.println("Enter publisher name");
				String pubName = scanner.next();

				BookInfo bookInfo = new BookInfo();
				bookInfo.setBookId(bookId);
				bookInfo.setBookName(bookName);
				bookInfo.setBookAuthor(bookAuth);

				bookInfo.setNoOfBooks(bookNum);
				bookInfo.setPublisher(pubName);

				if (adminBookService.addBook(bookInfo)) {
					System.out.println("Books added successfully with " + bookNum + "copy");
				}
				break;
			case 2:
				System.out.println("Enter UserId: ");
				int usrId = scanner.nextInt();
				System.out.println("Enter UserName:");
				String usrName = scanner.next();
				System.out.println("Enter Email: ");
				String usrEmail = scanner.next();
				System.out.println("Enter Password:");
				String usrPassword = scanner.next();
				UserInfoBean userInfoBean = new UserInfoBean();
				userInfoBean.setUsrId(usrId);
				userInfoBean.setUsrName(usrName);
				userInfoBean.setUsrEmail(usrEmail);
				userInfoBean.setUsrPassword(usrPassword);
				if (adminBookService.addUser(userInfoBean)) {
					System.out.println("Successfully Added the User");
				}
				break;
			case 3:
				System.out.println("enter the Book id for delete");
				int bookId1 = scanner.nextInt();
				if (adminBookService.deleteBook(bookId1)) {
					System.out.println("Deleted Successfully");
				} else {
					System.out.println("Book Id not found");
				}
				break;
			case 4:
				System.out.println("enter the user id for delete");
				int userId = scanner.nextInt();
				if (adminBookService.deleteUser(userId)) {
					System.out.println("Deleted Successfully");
				} else {
					System.out.println("User Id not found");
				}
				break;
			case 5:
				System.out.println("---User Details---");
				List<UserInfoBean> list1 = adminBookService.showAllUser();
				if (!list1.isEmpty()) {
					for (UserInfoBean users : list1) {
						System.out.println(
								"User Id=" + users.getUsrId() + "\t User Name=" + users.getUsrName() + "\t User Email="
										+ users.getUsrEmail() + "\t User Password=" + users.getUsrPassword());
					}
				} else {
					System.out.println("No Users to show");
				}
				break;
			case 6:
				System.out.println("---Book Details---");
				List<BookInfo> list = adminBookService.showAllBooks();
				if (!list.isEmpty()) {
					for (BookInfo books : list) {
						System.out.println("Book Id=" + books.getBookId() + "\t Book Name = " + books.getBookName()
								+ " \t Book Author = " + books.getBookAuthor() + "\t Number of book copies"
								+ books.getNoOfBooks() + "\t Publisher Name=" + books.getPublisher());
					}
				} else {
					System.out.println("No books to show");
				}
				break;
			case 7:
				UserInfoBean bean = new UserInfoBean();
				System.out.println("Enter User Id to Update");
				bean.setUsrId(scanner.nextInt());
				System.out.println("Enter User Name to Update");
				bean.setUsrName(scanner.next());
				System.out.println("Enter User Email to Update");
				bean.setUsrEmail(scanner.next());
				System.out.println("Enter User Passsword to Upadte");
				bean.setUsrPassword(scanner.next());
				if (adminBookService.updateUser(bean) != null) {
					System.out.println("Updated Successfully!!!");

				} else {
					System.out.println("Failed to Update");
				}

				break;

			case 8:
				System.out.println("Logout Successfull");
				LibraryMainPage.main(null);
				System.exit(0);

			default:
				System.out.println("Invalid choice");
				break;
			}

		}
	}

	public void user() {
		System.out.println("User login successfully");
		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1.Boorow Book\n2.Search Book");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				break;
			case 2:
				displaySearchBook();
				break;

			}
		}

	}

	private void displaySearchBook() {
		System.out.println("Search Based on Book Id");
		int bookId = scanner.nextInt();
		BookInfo book = userService.searchBook(bookId);
		if (book != null) {
			System.out.println(book.getBookName());
			System.out.println(book.getBookAuthor());
			System.out.println(book.getNoOfBooks());
			System.out.println(book.getPublisher());
		} else {
			System.out.println("Book Not Found");
		}

	}

}
