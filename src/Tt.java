
public class Tt {

	public static void main(String string[]){
		String str[] = {"abc "," ","xyz"};
		int len = str.length;
		String s ="";
        for(int i=0;i<len;i++){
            s+=str[i].replaceAll(" ", "%20");
        }
//        str = s;
        System.out.println(s);
	}
}
