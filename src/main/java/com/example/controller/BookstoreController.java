package com.example.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.entity.Bookstore;
import com.example.service.BookstoreService;

@Controller
@RequestMapping("/books")
public class BookstoreController {

	@Autowired
	BookstoreService bookstoreService;
	
	@RequestMapping(value ={"/",""})
	@ResponseBody
	public String toBookHome(){
		return "books Home";
	}
	
	
	@RequestMapping(value ={"/all"})
	@ResponseBody
	public List<Bookstore> getAll(){
		List<Bookstore> list = new ArrayList<Bookstore>();
		
		list = bookstoreService.getAll();
		return list;
	}

	@RequestMapping(value ={"/count"})
	@ResponseBody
	public int getCount(){		
		return bookstoreService.getCount();
	}

	@RequestMapping(value ={"/money"})
	@ResponseBody
	public String getMoney(){		
		return bookstoreService.showmethemoney();
	}
	

	
	@RequestMapping(value ={"/save"})
	@ResponseBody
	public Bookstore toSave() {
		Bookstore bs = new Bookstore();
		Bookstore bs2 = new Bookstore();
		bs.setBid("1012345091");
		bs.setBookname("Costco成功關鍵");
		bs.setAuthor("Costco");
		bs.setPublisher("商周");
		bs.setPrice(new BigDecimal(599));
		bs.setVersion("0.9");
		
		bs2 = bookstoreService.save2(bs);
		
		return bs2;		
	}

	@RequestMapping(value ={"/getall"})
	@ResponseBody

	public List<Bookstore> togetAll() {
		List<Bookstore> lists = new ArrayList<Bookstore>();
		lists = bookstoreService.getAll2();		
		return lists;		
	}

	@RequestMapping(value ={"/getstring"})
	@ResponseBody

	public String toGetString() {		
		return  bookstoreService.getString();		
	}

	@RequestMapping(value ={"/findbook"})
	@ResponseBody
	public List<Bookstore> likeBookname(@RequestParam String bookname) {
		return  bookstoreService.getLikeBookname(bookname);		
	}
	
	@RequestMapping(value ={"/getmybook"})
	@ResponseBody
	public Bookstore getMyBook(@RequestParam String bid) {
		return  bookstoreService.getMyBook(bid);		
	}
	@RequestMapping(value ={"/db"})
	@ResponseBody
	public String getDbVersion() {
		return  bookstoreService.getDbVersion();		
	}
	@RequestMapping(value ={"/db2"})
	@ResponseBody
	public String getDb2() {	
		return  bookstoreService.getDb2();
	}
	@RequestMapping(value ={"/db3"})
	@ResponseBody
	public String getDb3() {	
		return  bookstoreService.getDb3();
	}
	
}
