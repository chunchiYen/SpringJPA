package com.example.util;

public class Counter {
	public static int amount =0;
	
	
	public  void  setAmount() {
		synchronized (this)
		{
			amount = amount + 1;
			}
	}
	public int getAmount()
	{	return amount;}
	public String toString() {
		return String.valueOf(amount);
	}
}
