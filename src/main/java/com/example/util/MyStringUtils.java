package com.example.util; 

import java.util.regex.Pattern;


public class MyStringUtils {
	
	public static int intLen = 10;
	public static int floatLen = 38;
    public static final String SPACE = " ";
    public static final String EMPTY = "";
    
	public MyStringUtils() {
		super();
	}
	public static boolean  isEmptyOrNull(String string){
		if(string == null) 
			return true;	
		if(string.isEmpty())
			return true;
		if(string.length() ==0)
			return true;
		return false;		
	}
	
	public static boolean isNumberic(String string) {
		// 正負號出現0~1次，整數部份0~9出現 0~ intLen 次，小數部份出現0~38次
		 String pattern = "^[+-]{0,1}[0-9]{0," + intLen +"}\\.{0,1}[0-9]{0,38}";
		boolean isMatch = Pattern.matches(pattern, string);

		return isMatch;
	}

	public static boolean isNegativeNumber(String string) {
		boolean isNagetive = false;		
		if(isNumberic(string)) {
			isNagetive = string.substring(0, 1).equals("-");
		}
	
		return isNagetive;
	}

	public static boolean isMathchIntLen(String string) {
		boolean isMatch =false;	
	
		// 是否為非負數值	
		if(isNumberic(string)) {			
			if(!isNegativeNumber(string)) {							
				if(string.substring(0, 1).equals("+") && string.indexOf(".")!=-1) {		
					// 若非負數值最前方有「+」符號且有小數點，判斷「+」 至 「.」之間字串長度是否小於等於設定值 intLen
					isMatch = string.substring(1, string.indexOf(".")).length() <= intLen ;		
					
				}else if(string.substring(0, 1).equals("+") && string.indexOf(".") ==-1) {				
					// 若非負數值最前方有「+」符號, 但沒小數點，判斷判斷「+」 至 字串最後字元否小於等於設定值	intLen
					isMatch = string.substring(1, string.length()).length() <= intLen ;						
				}else if(!string.substring(0, 1).equals("+") && string.indexOf(".") !=-1) {
					isMatch = string.substring(0, string.indexOf(".")).length() <= intLen ;
				}else {										
				
					// 若非負數值最前方沒有「+」符號且沒有小數點，判斷字串長度是否小於設定值 intLen
					isMatch = string.length() <= intLen ;
				}
			}	
		}

		return isMatch;
	}
}
