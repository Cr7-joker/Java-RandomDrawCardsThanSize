package com.poker;

public class Poker {

	private String color;
	private String count;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Poker(String color,String count) {
		this.color=color;
		this.count=count;
	}
	public Poker() {
		
	}

}
