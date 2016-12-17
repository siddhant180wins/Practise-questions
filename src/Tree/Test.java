package Tree;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Test {
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */
		//BufferedReader
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // int N = Integer.parseInt(line);

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
		
        while(N-- >0){
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	String input = br.readLine();
   			
        	
        	int len = input.length();
        	int[] start = new int[256];
        	int[] end = new int[256];
        	for(int i=0;i<256;i++){
        		start[i]=-1;
        		end[i]=-1;
        	}
        	
        	for(int i=0;i<len;i++){
        		char c = input.charAt(i);
        		if(i<start[c] && start[c]!=-1) {
        			start[c] = i;
        		}
        		if(start[c]==-1) start[c]=i;
        		if(i>end[c] && end[c]!=-1) {
        			end[c] = i;
        		}
        		if(end[c]==-1) end[c]=i;
        	}
        	int minVal=Integer.MAX_VALUE;
        	for(int i=0;i<256;i++){
        		
        		if(start[i]!=-1 && end[i]!=-1 && start[i]!=end[i]){
        			int min = len -1- (end[i] - start[i] );
        			if(min<minVal && min>=0) minVal = min;
        		}
        	}
        	if(minVal==Integer.MAX_VALUE)
        		minVal= -1;
        	System.out.println(minVal);
        }
    }
}
