package com.poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Run {
	public Player player1=new Player();
	public Player player2=new Player();
	public Poker[] poker;
	public void washCard() {
		String[] color=new String[]{"黑桃","红桃","梅花","方块"};
		String[] count=new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};	
		poker= new Poker[color.length*count.length];
		int a=0;		
		for(int i=0;i<color.length;i++) {
			for(int k=0;k<count.length;k++) {
				poker[a]=new Poker(color[i],count[k]);
				a++;
			}
		}
		System.out.println("----------创建扑克牌成功！----------");
		int b=0;
		for(int i=0;i<color.length;i++) {
			for(int k=0;k<count.length;k++) {
				System.out.print(poker[b].getColor()+poker[b].getCount()+"	");
				b++;
			}
			System.out.println();
		}
		for(int i=0;i<a;i++) {
			int l=(int)(Math.random()*(a-1));
			Poker newPoker=new Poker();
			newPoker=poker[i];
			poker[i]=poker[l];
			poker[l]=newPoker;
		}
		System.out.println("----------洗牌成功！----------");
	}
	
	public void creatPlayer() {
		System.out.println();
		System.out.println("----------创建玩家（两名）----------");
		Scanner console=new Scanner(System.in);
		while(true) {
			try {
				console=new Scanner(System.in);
				System.out.println("请输入第一位玩家的ID和姓名：");
				System.out.println("输入ID：");
				int id=console.nextInt();
				System.out.println("输入姓名：");
				String name=console.next();
				player1.setId(id);
				player1.setName(name);
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("请输入整数型ID！！！");
			}
			catch(Exception e) {
				System.out.println("出现其他错误！！！");
			}
		}
		while(true) {
			try {
				console=new Scanner(System.in);
				System.out.println("请输入第二位玩家的ID和姓名：");
				System.out.println("输入ID：");
				int id2=console.nextInt();
				System.out.println("输入姓名：");
				String name2=console.next();
				player2.setId(id2);
				player2.setName(name2);
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("请输入整数型ID！！！");
			}
			catch(Exception e) {
				System.out.println("出现其他错误！！！");
			}
		}
		System.out.println("-----欢迎玩家："+player1.getName()+"和"+player2.getName());
		console.close();
	}
	
	public void sendCard() {
		System.out.println();
		System.out.println("----------开始发牌----------");
		player1.handCard.add(poker[0]);
		System.out.println("-----玩家："+player1.getName()+"-拿牌");
		player2.handCard.add(poker[1]);
		System.out.println("-----玩家："+player2.getName()+"-拿牌");
		player1.handCard.add(poker[2]);
		System.out.println("-----玩家："+player1.getName()+"-拿牌");
		player2.handCard.add(poker[3]);
		System.out.println("-----玩家："+player2.getName()+"-拿牌");
		System.out.println("----------发牌结束！----------");
	}
	
	public void gameStart() {
		System.out.println();
		System.out.println("----------游戏开始----------");
		Collections.sort(player1.handCard,new Comparator());
		System.out.println(player1.getName()+"最大的手牌为："+player1.handCard.get(1).getColor()+player1.handCard.get(1).getCount());
		Collections.sort(player2.handCard,new Comparator());
		System.out.println(player2.getName()+"最大的手牌为："+player2.handCard.get(1).getColor()+player2.handCard.get(1).getCount());
		List<Poker> list=new ArrayList<Poker>();
		list.add(player1.handCard.get(1));
		list.add(player2.handCard.get(1));
		Collections.sort(list,new Comparator());
		if(list.get(1)==player1.handCard.get(1))
			System.out.println("----------玩家："+player1.getName()+"获胜！----------");
		else
			System.out.println("----------玩家："+player2.getName()+"获胜！----------");
		System.out.println("各自的手牌为：\n"+player1.getName()+":["+player1.handCard.get(0).getColor()+player1.handCard.get(0).getCount()+","+player1.handCard.get(1).getColor()+player1.handCard.get(1).getCount()+"]\n"+player2.getName()+":["+player2.handCard.get(0).getColor()+player2.handCard.get(0).getCount()+","+player2.handCard.get(1).getColor()+player2.handCard.get(1).getCount()+"]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run run=new Run();
		run.washCard();
		run.creatPlayer();
		run.sendCard();
		run.gameStart();
	}

}
