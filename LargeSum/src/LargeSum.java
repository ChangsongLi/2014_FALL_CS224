import java.math.BigInteger;
import java.util.Scanner;


public class LargeSum {
	public void solve(){
		Scanner scan = new Scanner(System.in);
		String s;
		BigInteger b = new BigInteger("0");
		while( !(s = scan.nextLine()).equals("END") ){
			b = b.add(new BigInteger(s));
			
		}
		System.out.println(b.toString().substring(0,10));
		scan.close();
	}

	public static void main(String[] args) {
		LargeSum ls = new LargeSum();
		ls.solve();
	}

}
