package codechef;

import java.util.Scanner;

public class Q1DEC {
	public static void main(String s[]){
		int t;
		int n;
		Scanner sc  = new Scanner(System.in);
		t = sc.nextInt();
		while(t>=0){
			n = sc.nextInt();
			int berth = n%8;
			int mul = n/8;
			int cp;
			String b="SL";
			switch(berth){
			case 1:
			case 4: b = "LB";break;
			case 2:
			case 5: b = "MB";break;
			case 3:
			case 6: b = "UB";break;
			}
			if(berth<=3 && berth!=0){
				cp = (berth +3);
				
			}else if(berth >3 && berth<=6 && berth!=0){
				cp = berth - 3;
			}else if(berth == 7){
				cp = 8;
				b= "SU";
			}else{
				cp = 7;
				b="SL";
			}
			cp = mul*8+cp;
			System.out.println(cp+b);
			
			t--;
		}
	}
}
