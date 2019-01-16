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
		String[] color=new String[]{"����","����","÷��","����"};
		String[] count=new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};	
		poker= new Poker[color.length*count.length];
		int a=0;		
		for(int i=0;i<color.length;i++) {
			for(int k=0;k<count.length;k++) {
				poker[a]=new Poker(color[i],count[k]);
				a++;
			}
		}
		System.out.println("----------�����˿��Ƴɹ���----------");
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
		System.out.println("----------ϴ�Ƴɹ���----------");
	}
	
	public void creatPlayer() {
		System.out.println();
		System.out.println("----------������ң�������----------");
		Scanner console=new Scanner(System.in);
		while(true) {
			try {
				console=new Scanner(System.in);
				System.out.println("�������һλ��ҵ�ID��������");
				System.out.println("����ID��");
				int id=console.nextInt();
				System.out.println("����������");
				String name=console.next();
				player1.setId(id);
				player1.setName(name);
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("������������ID������");
			}
			catch(Exception e) {
				System.out.println("�����������󣡣���");
			}
		}
		while(true) {
			try {
				console=new Scanner(System.in);
				System.out.println("������ڶ�λ��ҵ�ID��������");
				System.out.println("����ID��");
				int id2=console.nextInt();
				System.out.println("����������");
				String name2=console.next();
				player2.setId(id2);
				player2.setName(name2);
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("������������ID������");
			}
			catch(Exception e) {
				System.out.println("�����������󣡣���");
			}
		}
		System.out.println("-----��ӭ��ң�"+player1.getName()+"��"+player2.getName());
		console.close();
	}
	
	public void sendCard() {
		System.out.println();
		System.out.println("----------��ʼ����----------");
		player1.handCard.add(poker[0]);
		System.out.println("-----��ң�"+player1.getName()+"-����");
		player2.handCard.add(poker[1]);
		System.out.println("-----��ң�"+player2.getName()+"-����");
		player1.handCard.add(poker[2]);
		System.out.println("-----��ң�"+player1.getName()+"-����");
		player2.handCard.add(poker[3]);
		System.out.println("-----��ң�"+player2.getName()+"-����");
		System.out.println("----------���ƽ�����----------");
	}
	
	public void gameStart() {
		System.out.println();
		System.out.println("----------��Ϸ��ʼ----------");
		Collections.sort(player1.handCard,new Comparator());
		System.out.println(player1.getName()+"��������Ϊ��"+player1.handCard.get(1).getColor()+player1.handCard.get(1).getCount());
		Collections.sort(player2.handCard,new Comparator());
		System.out.println(player2.getName()+"��������Ϊ��"+player2.handCard.get(1).getColor()+player2.handCard.get(1).getCount());
		List<Poker> list=new ArrayList<Poker>();
		list.add(player1.handCard.get(1));
		list.add(player2.handCard.get(1));
		Collections.sort(list,new Comparator());
		if(list.get(1)==player1.handCard.get(1))
			System.out.println("----------��ң�"+player1.getName()+"��ʤ��----------");
		else
			System.out.println("----------��ң�"+player2.getName()+"��ʤ��----------");
		System.out.println("���Ե�����Ϊ��\n"+player1.getName()+":["+player1.handCard.get(0).getColor()+player1.handCard.get(0).getCount()+","+player1.handCard.get(1).getColor()+player1.handCard.get(1).getCount()+"]\n"+player2.getName()+":["+player2.handCard.get(0).getColor()+player2.handCard.get(0).getCount()+","+player2.handCard.get(1).getColor()+player2.handCard.get(1).getCount()+"]");
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
