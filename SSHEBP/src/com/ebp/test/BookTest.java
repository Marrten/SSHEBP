package com.ebp.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ebp.dao.AdminCategoryDAO;
import com.ebp.domain.Book;
import com.ebp.exception.BookAddExecption;
import com.ebp.exception.BookExistsExecption;
import com.ebp.exception.BookUpdateExecption;
import com.ebp.exception.CategoryException;
import com.ebp.service.BookService;

public class BookTest {

	public static void main(String[] args) throws BookExistsExecption, BookAddExecption, CategoryException, BookUpdateExecption {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/ebp/config/ApplicationContext.xml");
		//BookDAO bookDAO = (BookDAO) context.getBean("bookDAO");
		//QueryResult<Book> result = bookDAO.getBook(10, 1);
		//System.out.println(result.getList());
		BookService bookService  = (BookService) context.getBean("bookService");
		Book book = new Book(102,"学习型党组织建设党员干部读本","本书编写组","在全党营造崇尚学习的浓厚氛围",12,1.99,190);
		//id=102, name=学习型党组织建设党员干部读本, author=本书编写组, descration=在全党营造崇尚学习的浓厚氛围, oldprice=12.0, price=1.99, filename=null, amount=190, category_id=0
		bookService.update(book);
		//System.out.println(bookService.getBookById(102));
		//bookService.getBooks(queryBean)
		//System.out.println(bookService);
		
		AdminCategoryDAO adminCategoryDAO = (AdminCategoryDAO) context.getBean("adminCategoryDAO");
		//System.out.println(adminCategoryDAO);
		/*System.out.println();
		List<Category> list = adminCategoryDAO.findName(22);
		for (Category category : list) {
			System.out.println(category.getId()+category.getName());
		}*/
//		Map<String, Integer> map = adminCategoryDAO.getCategorys();
//		for (Entry<String, Integer> entry : map.entrySet()) {
//			System.out.println(entry.getValue()+entry.getKey());
//		}
		/*AdminCategoryService adminCategoryService  = (AdminCategoryService) context.getBean("adminCategoryService");
		System.out.println(adminCategoryService.getName(22));
		Map<String,Integer> map = adminCategoryService.getName(22);
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+entry.getValue());
		}*/
		//System.out.println(map.isEmpty());
		
		//Book book = bookDAO.getBooksById(88);
		//System.out.println(book);
		//Book book = bookDAO.getBookByName("七天提升绘画技巧");
		//System.out.println(book);
		
		//Book book = new Book("小黄人","不知道","不好看",100,50,"images/1/14/78e8e71c-3766-4354-8303-aaa1d31c3c1b.png",80,10);
		//bookDAO.insert(book);
		//List<Book> book = bookDAO.queryPage(50, 100);
//		System.out.println(book);
//		for (Book book2 : book) {
//			System.out.println(book2);
//		}
//		QueryBean queryBean = new QueryBean(10,10,10);
//		QueryResult result = bookDAO.getAllBook(queryBean);
//		List<Book> list = result.getList();
//		for (Book book : list) {
//			System.out.println(book);
//		}
		
		
	
	}

}
