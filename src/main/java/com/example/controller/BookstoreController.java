package com.example.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constant.CheckCodeConst;
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
		return "books Home .";
	}
	@RequestMapping(value ={"/bookadd"})
	public String toBookAdd(){
		return "BookAdd";
	}
	
	
	
	//consumes： 指定處理request的Content-Type, 例如 application/json; , text/html;
	//produces: 指定返回的內容類型，僅當requet請求header的accept類型中包含該指定類型才返回
	//headers： 指定request中必須包含某些指定的header值，才能讓方法處理請求
	//@RequestMapping(value ={"/booksave"} , produces="application/json; charset=utf-8")
	@RequestMapping(value ={"/booksave"} )
	//@ResponseBody
	public String toBookSave(@ModelAttribute(value = "BooksForm") Bookstore bookstore ,@RequestParam String checkCode , Model model){

		String reusltStr = "bid : " + bookstore.getBid() +" 新增失敗";		
		Bookstore resultBs =  bookstoreService.save2(bookstore);
		
		if(resultBs != null)
			reusltStr = "bid ： " +bookstore.getBid()  +" 新增成功";
		model.addAttribute("bookstore", resultBs);
		model.addAttribute("result", reusltStr);
		return "BookAdd";

		
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

	@RequestMapping(value ={"/del"})
	@ResponseBody
	public String toDel(@RequestParam(required=false) String bid, @RequestParam(required=false) String checkCode) {
		if(bid==null )
			return "請輸入bid";
		if(bid.isEmpty())
			return "bid錯誤";		
		if(checkCode==null)
			return "請輸入檢查碼";
		if(!CheckCodeConst.DEL_CHECK_CODE.equals(checkCode))	
			return "檢查碼錯誤";
		
		int result = bookstoreService.del(bid);
		if(result ==0 )
			return "無此資料";
		else
			return "刪除成功";
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
