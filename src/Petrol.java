import java.util.Arrays;
import java.util.Scanner;

public class Petrol {
	
	
	public static void main(String a[]){
		int t;
	    Scanner sc = new Scanner(System.in);
	    t = sc.nextInt();
	    while(t>0){
	    	int n = sc.nextInt();
	    	Integer cap[] = new Integer[n];
	    	Integer dist[] = new Integer[n];
	    	for(int i =0;i<n;i++){
	    		cap[i] = sc.nextInt();
	    }
	    for(int i=0;i<n;i++){
	    		dist[i] = sc.nextInt();
	    }
	    Boolean allowed[] = new Boolean[n];
	    Boolean validFirst[] = new Boolean[n];
	    int index = -1;
	    int minNeeded = Integer.MIN_VALUE;
	    int falsM = 0;
	    for(int i =0;i<n;i++){
	    		int prev = i<=0?n-1:i-1;
	    		allowed[i]  = false;
	    		validFirst[i] = false;
	    		int min=-1;
	    		
	    		if(dist[i]<=cap[i]){
	    			allowed[i] = true;
	    			validFirst[i] = true;
	    			min = dist[i];
	    		}else if(dist[i]<=(cap[i]+ cap[prev]-dist[prev])){
	    			allowed[i] = true;
	    			validFirst[i] = false;
	    			min = cap[i]+ cap[prev]-dist[prev];
	    		}else{
	    			falsM += cap[i]+ cap[prev]-dist[prev];
	    		}
	    		if(min>minNeeded){
	    			index = i;
	    			minNeeded = min+falsM;
	    		}
	    }
	    System.out.println(index+","+minNeeded);
	    n--;
	    }
	    t--;
	}
	
    
}
