import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxArrayNumberComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer n) {
		String c = Integer.toString(x) + Integer.toString(n);
		String d = Integer.toString(n) + Integer.toString(x);
		if (Integer.valueOf(c) > Integer.valueOf(d))
			return -1;
		else if (Integer.valueOf(c) < Integer.valueOf(d))
			return 1;
		return 0;
	}

	public static void main(String s[]) {
		Integer a[] = { 60, 548, 24, 2, 32, 3 };
		Arrays.sort(a, new MaxArrayNumberComparator());
		System.out.println(Arrays.asList(a));
	}

}
