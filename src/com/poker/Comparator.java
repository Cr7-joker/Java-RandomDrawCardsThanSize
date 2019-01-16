package com.poker;

public class Comparator implements java.util.Comparator<Poker> {	
	@Override
	public int compare(Poker o1, Poker o2) {
		// TODO Auto-generated method stub
		int i,j,m,n;
		switch(o1.getCount()) {
			case "J":i=11;
			break;
			case "Q":i=12;
			break;
			case "K":i=13;
			break;
			case "A":i=14;
			break;
			default:
				i=Integer.valueOf(o1.getCount());
		}
		switch(o2.getCount()) {
		case "J":j=11;
		break;
		case "Q":j=12;
		break;
		case "K":j=13;
		break;
		case "A":j=14;
		break;
		default:
			j=Integer.valueOf(o2.getCount());
	}
		switch(o1.getColor()) {
		case "ºÚÌÒ":m=4;
		break;
		case "ºìÌÒ":m=3;
		break;
		case "Ã·»¨":m=2;
		break;
		case "·½¿é":m=1;
		break;
		default:m=0;
	}
	switch(o2.getColor()) {
	case "ºÚÌÒ":n=4;
	break;
	case "ºìÌÒ":n=3;
	break;
	case "Ã·»¨":n=2;
	break;
	case "·½¿é":n=1;
	break;
	default:n=0;
}
		Integer x=i;
		Integer y=j;
		Integer z=m;
		Integer w=n;
		if(i!=j)
			return x.compareTo(y);
		else
			return z.compareTo(w);
	}

}
