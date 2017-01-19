import java.util.Arrays;

public class Test {
	
	
	public static void main(String s[]){
		int numbers[] = {2,1,5,3,7,4};
		int target = 7;
		Arrays.sort(numbers);
        int f=0;
        int len = numbers.length;
        int l= numbers.length-1;
        int count=0;
        while(f<l && f<len && l>0){
        	
        	
            int sum = numbers[f]+numbers[l];
            if(sum==target){
                count++;
                f++;
                l--;
            }
            else if(sum<target){
                f++;
            }else
                l--;
        }
        System.out.println(count);
	}
}
