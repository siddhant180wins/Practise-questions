import java.util.Arrays;
import java.util.Scanner;

public class VikasTest {

	
	
	public static void main(String s[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
 		}
		
		int cost[] = new int[n];
		cost[0] = 2;
		int curStart = 0;
		for(int i=1;i<n;i++){
			int thiscost = cost[i-1]+VikasTest.getMinPrice(a[curStart],a[i]);
			int abscost = VikasTest.getAbsPrice(a[0], a[i]);
			int prevCost =  cost[i-1]+2;
			cost[i] = Math.min(thiscost,Math.min(abscost, prevCost));
			if(cost[i]==prevCost){
				curStart = i;
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			System.out.print(cost[i]+",");
		}
		System.out.println(cost[n-1]);
	}
	public static int getAbsPrice(int a,int b){
		int diff = Math.abs(a-b);
		if(diff <=1) return 2;
		if(diff <=7) return 7;
		if(diff <=31) return 25;
		return 25;
	}
	public static int getMinPrice(int a,int b){
		int diff = Math.abs(a-b);
		if(diff<=2 && diff >=1){
			return diff*2;
		}else if(diff >2 && diff <=3){
			return (diff/2)*2;
		}else if(diff >3 && diff <=7){
			return 7;
		}else if(diff >7 && diff <=21){
			return (diff/7)*7;
		}else {
			return 25;
		}
	}
}

