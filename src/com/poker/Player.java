package com.poker;
import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private String name;
	public List<Poker> handCard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Player() {
		this.handCard=new ArrayList<Poker>();
	}
	public Player(int id,String name) {
		this.id=id;
		this.name=name;
		this.handCard=new ArrayList<Poker>();
	}
}
