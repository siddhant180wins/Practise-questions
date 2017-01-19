import java.util.Scanner;

//1234
public class CoolNumber {

	public Long f(Long k ){
		Long kn = k;
		Long rev=0L;
		long dig=0L;
		while(kn!=0){
//			rev = kn%10;
			kn/=10;
			dig++;
		}
		dig--;
		rev = k;
		while(rev!=0){
			long d = rev%10;
			if(d>5){
				return getMin(dig+1);
			}
			if(d==5) return (long) (5*Math.pow(10, dig)+f(rev/10));
			if(d<5 && d>2){
				Double db = (5-d)*Math.pow(10, dig);
				return (long) (db+rev);
			}
			if(d==2){
				return (long) (2*Math.pow(10, dig)+f(rev/10));
			}
			if(d<2){
				Double db = (2-d)*Math.pow(10, dig);
				return (long) (db+rev);
			}
			rev/=10;
		}
		
		return 0L;
	}
	public Long f2(Long k){
		Long rev = k;
		boolean carry = false;
		Long act = 0L;
		int dig=0;
		while(rev!=0){
			dig++;
			long d = rev%10;
			if(d>5){
				act = act*10+2;
				carry = true;
			}
			if(d==5){
				if(carry){
					act=act*10+2;
				}else{
					act=act*10+5;
				}
			}
			if(d>2 && d<5){
				act=act*10+5;
//				carry=true;
			}
			if(d==2){
				if(carry){
					act=act*10+5;
				}else{
					act=act*10+2;
				}
			}
			if(d<2){
				act=act*10+2;
			}
			if(rev/10==0L){
				dig++;
				if(d>=5){
					if(carry){
						act=0L;
						while(dig!=0){
							act = act*10+2; 
							dig--;
						}
						return act;
					}
				}else{
//					if(carry){
//					act=act*10+5;
//					}
//				///	return act;
				}
			}
			
			rev/=10;
		}
		return act;
	}
	public Long getMin(long dig){
		Long n = 2L;
		while(dig>=0){
			n = n*10+2;
		}
		return n;
	}
	public static Long rev(Long kn){
		Long r=0L;
		while(kn!=0){
			r= r*10+kn%10;
			kn/=10;
		}
		return r;
	}
	
	public static void main(String s[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>=0){
			Long l,r;
			l = sc.nextLong();
			r = sc.nextLong();
			Long sum=0L;
			while(l<=r){
				sum+= CoolNumber.rev(new CoolNumber().f2(l));
				l++;
			}
			System.out.println(sum);
			t--;
		}
	}
}
//267
//522
//2123
//2222